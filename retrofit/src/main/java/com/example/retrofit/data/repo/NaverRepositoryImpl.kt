package com.example.retrofit.data.repo

import com.example.retrofit.data.source.remote.NaverRemoteDataSource
import com.example.retrofit.network.naver.model.NaverResponse

class NaverRepositoryImpl(private val naverRemoteDataSource: NaverRemoteDataSource) :
    NaverRepository {

    override fun searchNaverWord(
        word: String,
        onSuccess: (naverResponse: NaverResponse) -> Unit,
        onFailure: (errorMessage: String) -> Unit
    ) {
        naverRemoteDataSource.searchNaverWord(word, onSuccess, onFailure)
    }

    override fun searchNaverWordNotHigh(word: String, searchNaverCallback: SearchNaverCallback) {
        naverRemoteDataSource.searchNaverWordNotHigh(word, searchNaverCallback)
    }
}