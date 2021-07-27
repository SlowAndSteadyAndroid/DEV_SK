package com.example.mvvm.data.repo

interface MainRepository {
    fun getLocalData(): String
    fun setLocalData(data: String)
}