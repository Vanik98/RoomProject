package com.vanik.roomproject.db

import androidx.room.*
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

    @Query("SELECT * FROM car WHERE serialNumber = :serialNumber")
    fun getById(serialNumber: Long) : Car?

}