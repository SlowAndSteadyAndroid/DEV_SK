package com.example.mvvm.data.source.local

class LocalDataSourceImpl : LocalDataSource {
    override fun getData(): String {
        return "Local call getData"
    }


    companion object {

        private var instance: LocalDataSourceImpl? = null

        fun getInstance(): LocalDataSource =
            instance ?: LocalDataSourceImpl().also {
                instance = it
            }

    }
}