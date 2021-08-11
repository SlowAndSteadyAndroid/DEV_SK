package com.example.mvvm.data.source.local

class LocalDataSourceImpl : LocalDataSource {


    override fun getLocalData(): String {
        return localData
    }

    override fun setLocalData(data: String) {
        localData = data
    }

    companion object {

        private var localData = "getLocalData"

    }

}