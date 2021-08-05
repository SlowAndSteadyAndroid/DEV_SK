package com.example.retrofit.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.retrofit.data.repo.NaverRepository

class NaverViewModel(private val naverRepository: NaverRepository) : ViewModel() {

    fun getSearchResult(word: String) {

        naverRepository.searchNaverWord(word, onSuccess = {
            Log.d("결과", it.message.result.translatedText)
        }, onFailure = {
            Log.d("결과", it)
        })

    }
}