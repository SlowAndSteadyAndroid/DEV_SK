package com.example.samplemvvm.di

import com.example.samplemvvm.data.source.local.PersonLocalDataSource
import com.example.samplemvvm.data.source.local.PersonLocalDataSourceImpl
import org.koin.dsl.module

val sourceModule = module {
    single<PersonLocalDataSource> { PersonLocalDataSourceImpl(get()) }
}