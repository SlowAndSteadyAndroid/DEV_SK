package com.example.dev_sk.examsharedviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _updateNum = MutableLiveData<Int>(0)
    val updateNum: LiveData<Int> = _updateNum


    private val _updateString = MutableLiveData<String>("")
    val updateString: LiveData<String> = _updateString

    fun addTwo() {
        _updateNum.value = (updateNum.value ?: 0) + 2
    }

    fun addString(string: String) {
        _updateString.value = string
    }

}