package com.vanik.roomproject.db.dao

import androidx.room.*
import com.vanik.roomproject.entity.Car

@Dao
interface CarDao {
    @Query("SELECT * FROM car")
    fun getAll(): List<Car>
    //insert problems read
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(result: Car)

    @Update
    fun update(result: Car?)

    @Delete
    fun delete(result: Car)

    @Query("SELECT * FROM car WHERE serialNumber = :serialNumber")
    fun getById(serialNumber: Long) : Car?

    @Query("DELETE from car WHERE serialNumber IN (:serialNumber)")
    //return deleteListCount
    fun deleteByIdList(serialNumber: List<Long>): Int

    @Query("SELECT * FROM car WHERE model LIKE :search OR speed LIKE :search")
    fun getAllWithModelLikeOrSpeedLike(search: String?): List<Car>


}