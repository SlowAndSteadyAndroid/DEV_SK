package com.example.samplemvvm.data.source.local

import android.util.Log
import com.example.samplemvvm.data.model.Person
import com.example.samplemvvm.room.database.PersonDatabase
import com.example.samplemvvm.room.entity.PersonEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonLocalDataSourceImpl(private val personDatabase: PersonDatabase) :
    PersonLocalDataSource {

    override suspend fun registerPersonData(): Boolean = withContext(Dispatchers.IO) {
        getPersonList().forEach {
            personDatabase.personDao().registerPersonEntity(it.toPersonEntity())
        }
        return@withContext personDatabase.personDao().getAll().isNotEmpty()
    }

    override suspend fun getAllPersonData(): List<PersonEntity> = withContext(Dispatchers.IO) {
        return@withContext personDatabase.personDao().getAll()
    }

    override suspend fun checkExistPersonData(): Boolean = withContext(Dispatchers.IO) {
        return@withContext personDatabase.personDao().getAll().isNotEmpty()
    }

    private fun getPersonList(): List<Person> {
        return listOf(
            Person("A", 20, "Man", "Java"),
            Person("B", 22, "Woman", "Kotlin"),
            Person("C", 24, "Man", "Java Script"),
            Person("D", 26, "Woman", "IOS"),
            Person("A", 20, "Man", "Java"),
            Person("B", 22, "Woman", "Kotlin"),
            Person("C", 24, "Man", "Java Script"),
            Person("D", 26, "Woman", "IOS")

        )

    }

}