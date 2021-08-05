package com.example.samplemvvm.di

import com.example.samplemvvm.data.repo.PersonRepository
import com.example.samplemvvm.data.repo.PersonRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PersonRepository> { PersonRepositoryImpl(get()) }
}