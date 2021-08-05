package com.example.samplemvvm.ui.home

import androidx.lifecycle.*
import com.example.samplemvvm.data.model.Person
import com.example.samplemvvm.data.repo.PersonRepository
import com.example.samplemvvm.ui.splash.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val personRepository: PersonRepository) : ViewModel(), LifecycleObserver {

    private val _viewStateLiveData = MutableLiveData<ViewState>()
    val viewStateLiveData: LiveData<ViewState> = _viewStateLiveData


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getPersonData() {
        CoroutineScope(Dispatchers.Main).launch {
            val getPersonList = personRepository.getAllPersonData().map { it.toPerson() }
            _viewStateLiveData.value = HomeViewState.GetPersonData(getPersonList)
        }
    }


    sealed class HomeViewState : ViewState {
        data class GetPersonData(val personData: List<Person>) : HomeViewState()
    }
}