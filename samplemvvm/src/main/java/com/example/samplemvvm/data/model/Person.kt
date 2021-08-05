package com.example.samplemvvm.data.model

import com.example.samplemvvm.room.entity.PersonEntity


data class Person(
    var name: String = "",
    var age: Int = 0,
    var gender: String = "",
    var job: String = ""
) {
    fun toPersonEntity(): PersonEntity =
        PersonEntity(
            0, name, age, gender, job
        )
}