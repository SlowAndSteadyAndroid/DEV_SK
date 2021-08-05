package com.example.samplemvvm.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.samplemvvm.data.model.Person

@Entity(tableName = "person_table")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "job") val job: String
) {
    fun toPerson(): Person =
        Person(name, age, gender, job)
}
