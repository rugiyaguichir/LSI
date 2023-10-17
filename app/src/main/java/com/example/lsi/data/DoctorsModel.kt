package com.example.lsi.data

data class DoctorsModel(
    val id: Long,
    val name: String,
    val specialization: String,
    val shortDescription: String,
    val longDescription: String,
    val photo: String
)