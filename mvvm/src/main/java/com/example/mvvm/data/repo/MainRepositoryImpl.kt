package com.example.mvvm.data.repo

import com.example.mvvm.data.source.local.LocalDataSource
import com.example.mvvm.data.source.local.LocalDataSourceImpl

class MainRepositoryImpl(private val localDataSource: LocalDataSource) : MainRepository {

    override fun getData(): String {
        return localDataSource.getData()
    }


    companion object {

        private var instance: MainRepositoryImpl? = null

        fun getInstance(localDataSource: LocalDataSource): MainRepositoryImpl =
            instance ?: MainRepositoryImpl(localDataSource).also {
                instance = it
            }

    }
}