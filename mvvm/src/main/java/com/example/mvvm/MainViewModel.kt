package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val _mainViewStateLiveData = MutableLiveData<MainViewState>()
    val mainViewStateLiveData: LiveData<MainViewState> = _mainViewStateLiveData

    fun operation() {
        CoroutineScope(Dispatchers.Main).launch {

            startOperation()

            delay(2000)

            operationPlus()

            endOperation()

        }
    }


    private fun startOperation() {
        _mainViewStateLiveData.value = MainViewState.StartOperation
    }

    private fun endOperation() {
        _mainViewStateLiveData.value = MainViewState.EndOperation
    }

    private fun operationPlus() {
        _mainViewStateLiveData.value = MainViewState.OperationPlus
    }


    sealed class MainViewState {
        object StartOperation : MainViewState()
        object EndOperation : MainViewState()
        object OperationPlus : MainViewState()
    }

}

