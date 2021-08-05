package com.example.samplemvvm.di

import androidx.room.Room
import com.example.samplemvvm.room.database.PersonDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val networkModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            PersonDatabase::class.java,
            "person"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}