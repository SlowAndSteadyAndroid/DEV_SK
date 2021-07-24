package com.example.mvvm.data.source.local

class LocalDataSourceImpl : LocalDataSource {
    override fun getData(): String {
        return "Local call getData"
    }

}