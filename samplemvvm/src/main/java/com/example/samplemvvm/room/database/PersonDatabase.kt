package com.example.samplemvvm.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.samplemvvm.room.dao.PersonDao
import com.example.samplemvvm.room.entity.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao
}