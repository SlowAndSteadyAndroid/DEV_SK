package com.example.retrofit.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.retrofit.data.repo.SearchNaverCallback
import com.example.retrofit.data.repo.NaverRepository
import com.example.retrofit.network.naver.model.NaverResponse

class NaverViewModel(private val naverRepository: NaverRepository) : ViewModel() {

    fun getSearchResult(word: String) {

        naverRepository.searchNaverWord(word, onSuccess = {
            Log.d("결과", it.message.result.translatedText)
        }, onFailure = {
            Log.d("결과", it)
        })
    }

    fun getSearchResultNotHigh(word: String){

        naverRepository.searchNaverWordNotHigh(word, object : SearchNaverCallback {
            override fun onSuccess(naverResponse: NaverResponse) {
                Log.d("결과", naverResponse.message.result.translatedText)
            }

            override fun onFailure(string: String) {
                Log.d("결과", string)
            }
        })

    }
}