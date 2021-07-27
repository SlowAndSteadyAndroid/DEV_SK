package com.example.mvvm

import androidx.lifecycle.ViewModel
import com.example.mvvm.data.repo.MainRepository

class SubViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getLocalData(): String {
        return mainRepository.getLocalData()
    }
}