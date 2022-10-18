package com.vanik.roomproject.data.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.vanik.roomproject.data.roomdb.dao.CarDao
import com.vanik.roomproject.data.roomdb.dao.PersonCarDao
import com.vanik.roomproject.data.roomdb.dao.PersonDao
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.Person

@Database(entities = [Person::class, Car::class], version = 1)
@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CarDao(): CarDao
    abstract fun PersonDao(): PersonDao
    abstract fun PersonCarDao(): PersonCarDao

    companion object {
        fun getInstance(applicationContext: Context): AppDatabase {
            return Room.databaseBuilder(
                applicationContext, AppDatabase::class.java, "app_database"
            ).addMigrations(MIGRATION_1_2).build()
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Person ADD COLUMN birthday INTEGER DEFAULT 0 NOT NULL")
            }
        }
    }
}

