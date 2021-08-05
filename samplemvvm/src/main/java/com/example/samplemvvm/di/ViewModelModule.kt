package com.example.samplemvvm.di

import com.example.samplemvvm.ui.home.HomeViewModel
import com.example.samplemvvm.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}