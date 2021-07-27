package com.example.mvvm.data.repo

import com.example.mvvm.data.source.local.LocalDataSource

class MainRepositoryImpl(private val localDataSource: LocalDataSource) : MainRepository {
    override fun getLocalData(): String {
        return localDataSource.getLocalData()
    }

    override fun setLocalData(data: String) {
        localDataSource.setLocalData(data)
    }

    companion object {

        private var instance: MainRepositoryImpl? = null

        fun getInstance(localDataSource: LocalDataSource): MainRepositoryImpl =
            instance ?: MainRepositoryImpl(localDataSource).also {
                instance = it
            }

    }


}