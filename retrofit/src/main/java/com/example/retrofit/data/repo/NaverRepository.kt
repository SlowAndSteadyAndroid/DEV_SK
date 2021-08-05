package com.example.retrofit.data.repo

import com.example.retrofit.network.naver.model.NaverResponse

interface NaverRepository {

    fun searchNaverWord(
        word: String,
        onSuccess: (naverResponse: NaverResponse) -> Unit,
        onFailure: (errorMessage: String) -> Unit
    )
}