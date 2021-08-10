package com.example.homework1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    private val _sendValue = MutableLiveData<String>()
    val sendValue: LiveData<String> = _sendValue


    fun sendValue(string: String) {
        _sendValue.value = string
    }

}