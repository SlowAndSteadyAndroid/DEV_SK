package com.example.mvvm

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val inputA = MutableLiveData<String>()
    val inputB = MutableLiveData<String>()

    val resultObservableField = ObservableField("")


    fun operation(operationType: OperationType) {
        when(operationType){
            OperationType.PLUS -> {
                resultObservableField.set(
                    (inputA.value.orEmpty().toInt() + inputB.value.orEmpty().toInt()).toString()
                )
            }

        }
    }

}

enum class OperationType {
    PLUS
}
