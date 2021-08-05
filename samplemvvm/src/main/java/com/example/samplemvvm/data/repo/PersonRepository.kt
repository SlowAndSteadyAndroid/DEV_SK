package com.example.samplemvvm.data.repo

import com.example.samplemvvm.room.entity.PersonEntity

interface PersonRepository {

    suspend fun registerPersonData(): Boolean

    suspend fun getAllPersonData(): List<PersonEntity>

    suspend fun checkExistPersonData(): Boolean
}