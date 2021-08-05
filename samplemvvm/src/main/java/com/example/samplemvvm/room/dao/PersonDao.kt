package com.example.samplemvvm.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.samplemvvm.room.entity.PersonEntity

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun registerPersonEntity(personList: PersonEntity): Long

    @Query("SELECT * FROM person_table")
    fun getAll(): List<PersonEntity>
}