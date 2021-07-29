package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.repo.MainRepository
import com.example.mvvm.enums.Operation

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _mainViewStateLiveData = MutableLiveData<MainViewState>()
    val mainViewStateLiveData: LiveData<MainViewState> = _mainViewStateLiveData

    val input1LiveData = MutableLiveData<String>()
    val input2LiveData = MutableLiveData<String>()

    fun operation(operation: Operation) {


        when (operation) {
            Operation.PLUS -> {
                _mainViewStateLiveData.value = MainViewState.Operation(
                    (input1LiveData.value.orEmpty().toInt() + input2LiveData.value.orEmpty()
                        .toInt()).toString()
                )
            }

            Operation.MIN -> {
                _mainViewStateLiveData.value = MainViewState.Operation(
                    (input1LiveData.value.orEmpty().toInt() - input2LiveData.value.orEmpty()
                        .toInt()).toString()
                )
            }

            Operation.MUL -> {
                _mainViewStateLiveData.value = MainViewState.Operation(
                    (input1LiveData.value.orEmpty().toInt() * input2LiveData.value.orEmpty()
                        .toInt()).toString()
                )
            }

            Operation.DIV -> {
                _mainViewStateLiveData.value = MainViewState.Operation(
                    (input1LiveData.value.orEmpty().toInt() / input2LiveData.value.orEmpty()
                        .toInt()).toString()
                )
            }

        }
    }


    private fun startOperation() {
        _mainViewStateLiveData.value = MainViewState.StartOperation
    }

    private fun endOperation() {
        _mainViewStateLiveData.value = MainViewState.EndOperation
    }

    private fun routeSubActivity() {
        _mainViewStateLiveData.value = MainViewState.RouteSub
    }

    private fun updateLocalData() {
        mainRepository.setLocalData("updateData")
    }

    private fun getLocalData() {
        _mainViewStateLiveData.value = MainViewState.GetLocalData(mainRepository.getLocalData())
    }

    sealed class MainViewState {
        object StartOperation : MainViewState()
        object EndOperation : MainViewState()
        data class Operation(val resultOperation: String) : MainViewState() // dataClass
        object RouteSub : MainViewState()
        data class GetLocalData(val data: String) : MainViewState()
    }
}

