package com.example.mvvm.koin

import com.example.mvvm.data.source.local.LocalDataSource
import com.example.mvvm.data.source.local.LocalDataSourceImpl
import org.koin.dsl.module

val sourceModule = module {
    single<LocalDataSource> { LocalDataSourceImpl() }
}