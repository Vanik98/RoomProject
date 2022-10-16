package com.vanik.roomproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.Person

@Database(entities = [Person::class, Car::class], version = 1)
@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CarDao(): CarDao
    abstract fun PersonDao() : PersonDao

    companion object {
        fun getInstance(applicationContext: Context): AppDatabase {
            return Room.databaseBuilder(
                applicationContext, AppDatabase::class.java, "app_database"
            ).allowMainThreadQueries().build()
        }
    }
}

