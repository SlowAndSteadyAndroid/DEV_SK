package com.example.retrofit.data.source.remote

import com.example.retrofit.network.naver.NaverApi
import com.example.retrofit.network.naver.model.NaverResponse
import com.example.retrofit.util.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NaverRemoteDataSourceImpl : NaverRemoteDataSource {

    override fun searchNaverWord(
        word: String,
        onSuccess: (naverResponse: NaverResponse) -> Unit,
        onFailure: (errorMessage: String) -> Unit
    ) {

        Retrofit.getNaverApi()
            .searchWord(NaverApi.CLIENT_ID, NaverApi.CLIENT_SECRET, "ko", "en", word).enqueue(object : Callback<NaverResponse>{
                override fun onResponse(
                    call: Call<NaverResponse>,
                    response: Response<NaverResponse>
                ) {
                    response.body()?.let(onSuccess)
                }

                override fun onFailure(call: Call<NaverResponse>, t: Throwable) {
                    t.message?.let(onFailure)
                }
            })
    }
}