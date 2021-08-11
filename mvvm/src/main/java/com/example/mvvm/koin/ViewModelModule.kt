package com.example.mvvm.koin

import com.example.mvvm.MainViewModel
import com.example.mvvm.SubViewModel
import com.example.mvvm.ThirdViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { SubViewModel(get()) }
    viewModel { ThirdViewModel(get()) }
}