package com.vanik.roomproject.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.vanik.roomproject.entity.Car

@Database(entities = [Car::class], version = 1)
//@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CarDao(): CarDao
    companion object{
         fun getInstance(applicationContext: Context): AppDatabase {
            return Room.databaseBuilder(
                applicationContext, AppDatabase::class.java, "car_database"
            ).allowMainThreadQueries().build()
        }
    }
}

//


//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
//            }
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                AppDatabase::class.java, "car"
//            )
//                .addCallback(object : Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
//                        ioThread {
//                            insertData(getInstance(context))
//                        }
//                    }
//                })
//                .build()
//
//        private fun insertData(appDatabase: AppDatabase) {
//            for (i in 1..10) {
//                val serialNumber: Long = (i * 1000000000).toLong()
//                val car = Car(serialNumber, "mercedes", 200)
//                appDatabase.CarDao().insert(car)
//            }
//        }
//    }
