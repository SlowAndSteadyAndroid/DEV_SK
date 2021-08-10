package com.example.homework1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private val _updateNum = MutableLiveData<Int>(0)
    val updateNum: LiveData<Int> = _updateNum

    fun addTwo() {
        _updateNum.value = (updateNum.value ?: 0) + 2
    }

    private val _sendValue = MutableLiveData<String>()
    val sendValue: LiveData<String> = _sendValue


    fun sendValue(string: String) {
        _sendValue.value = string
    }
}