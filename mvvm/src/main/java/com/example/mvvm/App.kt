package com.example.mvvm

import android.app.Application
import com.example.mvvm.koin.repositoryModule
import com.example.mvvm.koin.sourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(repositoryModule, sourceModule))
        }
    }
}