package com.example.dev_sk.examsharedviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _updateNum = MutableLiveData<Int>(0)
    val updateNum: LiveData<Int> = _updateNum


    fun addTwo() {
        _updateNum.value = (updateNum.value ?: 0) + 2
    }

}