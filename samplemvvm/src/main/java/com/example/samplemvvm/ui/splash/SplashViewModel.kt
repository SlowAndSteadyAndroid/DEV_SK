package com.example.samplemvvm.ui.splash

import androidx.lifecycle.*
import com.example.samplemvvm.data.repo.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(private val personRepository: PersonRepository) : ViewModel(), LifecycleObserver {

    // view 의 상태를 변화시킬때 필요한 liveData
    private val _viewStateLiveData = MutableLiveData<ViewState>()
    val viewStateLiveData: LiveData<ViewState> = _viewStateLiveData

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun verifyPersonData() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1500L)
            if (personRepository.checkExistPersonData()) {
                _viewStateLiveData.value = SplashViewState.RouteMain
            } else {
                if (personRepository.registerPersonData()) {
                    _viewStateLiveData.value = SplashViewState.RouteMain
                } else {
                    _viewStateLiveData.value = SplashViewState.Error
                }
            }
        }
    }

    sealed class SplashViewState : ViewState {
        object RouteMain : SplashViewState()
        object Error : SplashViewState()
    }

}

interface ViewState