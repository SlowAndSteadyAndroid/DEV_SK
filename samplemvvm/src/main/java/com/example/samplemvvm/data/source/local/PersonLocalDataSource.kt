package com.example.samplemvvm.data.source.local

import com.example.samplemvvm.room.entity.PersonEntity

interface PersonLocalDataSource {

    suspend fun registerPersonData(): Boolean

    suspend fun getAllPersonData(): List<PersonEntity>

    suspend fun checkExistPersonData(): Boolean

}