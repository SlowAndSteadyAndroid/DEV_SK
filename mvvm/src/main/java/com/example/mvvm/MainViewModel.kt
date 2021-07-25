package com.example.mvvm

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.repo.MainRepository

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val inputA = MutableLiveData<String>()
    val inputB = MutableLiveData<String>()

    val resultObservableField = ObservableField("")

    private val _localStringLiveData = MutableLiveData<String>()
    val localStringLiveData: LiveData<String> = _localStringLiveData

    fun operation(operationType: OperationType) {
        when (operationType) {
            OperationType.PLUS -> {
                resultObservableField.set(
                    (inputA.value.orEmpty().toInt() + inputB.value.orEmpty().toInt()).toString()
                )
            }

        }
    }

    fun getLocalData() {
        _localStringLiveData.value = mainRepository.getData()
    }

}

enum class OperationType {
    PLUS
}
