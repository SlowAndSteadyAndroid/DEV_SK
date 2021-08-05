package com.example.retrofit.network.naver.model

data class Message(
    val service: String,
    val type: String,
    val version: String,
    val result: Result
)