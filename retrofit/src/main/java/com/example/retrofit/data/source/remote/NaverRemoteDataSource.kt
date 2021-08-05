package com.example.retrofit.data.source.remote

import com.example.retrofit.network.naver.model.NaverResponse

interface NaverRemoteDataSource {

    fun searchNaverWord(
        word: String,
        onSuccess: (naverResponse: NaverResponse) -> Unit,
        onFailure: (errorMessage: String) -> Unit
    )
}