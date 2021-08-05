package com.example.retrofit.network.naver

import com.example.retrofit.network.naver.model.NaverResponse
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface NaverApi {

    companion object{
        const val CLIENT_ID = "iagNSAuZcDCq_KlAofc4"
        const val CLIENT_SECRET = "7CyJ8z8feP"
    }

    @POST("v1/papago/n2mt.json")
    fun searchWord(
        @Header("X-Naver-Client-Id")clientId: String,
        @Header("X-Naver-Client-Secret")secretKey: String,
        @Query("source") source : String,
        @Query("target") target : String,
        @Query("text") text : String
    ) : Call<NaverResponse>



}