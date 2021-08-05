package com.example.samplemvvm.data.repo

import com.example.samplemvvm.data.source.local.PersonLocalDataSource
import com.example.samplemvvm.room.entity.PersonEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonRepositoryImpl(private val personLocalDataSource: PersonLocalDataSource) :
    PersonRepository {
    override suspend fun registerPersonData(): Boolean = withContext(Dispatchers.IO) {
        return@withContext personLocalDataSource.registerPersonData()
    }

    override suspend fun getAllPersonData(): List<PersonEntity> = withContext(Dispatchers.IO) {
        return@withContext personLocalDataSource.getAllPersonData()
    }

    override suspend fun checkExistPersonData(): Boolean = withContext(Dispatchers.IO) {
        return@withContext personLocalDataSource.checkExistPersonData()
    }
}