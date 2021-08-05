package com.example.retrofit.util

import com.example.retrofit.network.naver.NaverApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    private val NAVER_BASE_URL = "https://openapi.naver.com/"

    fun getNaverApi(): NaverApi {
        return Retrofit.Builder()
            .baseUrl(NAVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NaverApi::class.java)
    }

}