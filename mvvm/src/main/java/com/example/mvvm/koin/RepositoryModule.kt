package com.example.mvvm.koin

import com.example.mvvm.data.repo.MainRepository
import com.example.mvvm.data.repo.MainRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}