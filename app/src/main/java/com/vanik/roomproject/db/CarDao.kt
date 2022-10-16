package com.vanik.roomproject.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.vanik.roomproject.entity.Car

@Dao
interface CarDao {
    @Query("SELECT * FROM car")
    fun getAll(): List<Car>
    //insert problems read
    @Insert
    fun insert(result: Car)

    @Update
    fun update(result: Car?)

    @Delete
    fun delete(result: Car)
}