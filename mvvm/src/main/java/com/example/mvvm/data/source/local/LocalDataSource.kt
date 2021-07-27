package com.example.mvvm.data.source.local

interface LocalDataSource {
    fun getLocalData(): String
    fun setLocalData(data: String)
}