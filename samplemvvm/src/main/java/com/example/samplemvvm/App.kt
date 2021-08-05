package com.example.samplemvvm

import android.app.Application
import com.example.samplemvvm.di.networkModule
import com.example.samplemvvm.di.repositoryModule
import com.example.samplemvvm.di.sourceModule
import com.example.samplemvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKOIN()
    }

    private fun startKOIN() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    sourceModule,
                    repositoryModule
                )
            )

        }
    }
}