package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.repo.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _mainViewStateLiveData = MutableLiveData<MainViewState>()
    val mainViewStateLiveData: LiveData<MainViewState> = _mainViewStateLiveData

    fun operation() {
        CoroutineScope(Dispatchers.Main).launch {
            getLocalData()

            startOperation()

            delay(1000)

            operationPlus()

            endOperation()

            delay(1000)

            updateLocalData()
            getLocalData()

            delay(1000)
            routeSubActivity()
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
        object OperationPlus : MainViewState() // dataClass
        object RouteSub : MainViewState()
        data class GetLocalData(val data: String) : MainViewState()
    }
}
