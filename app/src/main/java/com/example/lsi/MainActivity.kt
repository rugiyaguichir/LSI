package com.example.lsi

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.lsi.bottom_navigation.MainScreen
import com.example.lsi.bottom_navigation.Screen1
import com.example.lsi.bottom_navigation.Screen2
import com.example.lsi.bottom_navigation.Screen3
import com.example.lsi.data.DoctorsModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.TlsVersion
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val doctorsList = remember {
                mutableStateOf(listOf<DoctorsModel>())
            }
            getData(this, doctorsList)

            MainScreen(doctorsList)
            Log.d("MyLog", "$doctorsList")

        }


    }
}


@OptIn(DelicateCoroutinesApi::class)
private fun getData(context: Context, doctorsList: MutableState<List<DoctorsModel>>) {
    GlobalScope.launch(Dispatchers.IO) {
        try {
            val trustAllCertificates = arrayOf<TrustManager>(@SuppressLint("CustomX509TrustManager")
            object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) = Unit
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) = Unit
            })

            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, trustAllCertificates, null)

            val client = OkHttpClient.Builder()
                .sslSocketFactory(sslContext.socketFactory, trustAllCertificates[0] as X509TrustManager)
                .hostnameVerifier { _, _ -> true }
                .build()

            val url = "https://192.168.233.234:7216/api/doctors"

            val request = okhttp3.Request.Builder()
                .url(url)
                .build()

            val response: Response = client.newCall(request).execute()

            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                responseBody?.let { responseString ->
                    val list = getDoctors(responseString)
                    doctorsList.value = list
                }
            } else {
                Log.d("MyLog", "Error: ${response.code}")
            }
        } catch (e: Exception) {
            Log.d("MyLog", "Exception: $e")
        }
    }
}


private fun getDoctors(response: String): List<DoctorsModel> {

    if (response.isEmpty()) {
        Log.d("MyLog", "dsfsdf")
        return listOf()
    }
    val list = ArrayList<DoctorsModel>()
    val doctors = JSONArray(response)
    for (i in 0 until doctors.length()) {
        val item = doctors[i] as JSONObject
        list.add(
            DoctorsModel(
                item.getLong("id"),
                item.getString("name"),
                item.getString("specialization"),
                item.getString("shortDescription"),
                item.getString("longDescription"),
                item.getString("photo")

            )
        )


    }
    return list
}