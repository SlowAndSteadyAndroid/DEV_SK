package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val inputA = MutableLiveData<String>()
    val inputB = MutableLiveData<String>()

    private val _resultValue = MutableLiveData<String>()
    val resultValue: LiveData<String> = _resultValue

    fun plusLogic() {
        _resultValue.value = (inputA.value!!.toInt() + inputB.value!!.toInt()).toString()
    }

}