package com.vanik.roomproject.data.roomdb.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vanik.roomproject.entity.Car

@Dao
interface CarDao {

    @Query("SELECT * FROM car")
    fun getAllCars(): LiveData<List<Car>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(result: Car)

    @Update
    suspend fun update(result: Car?)

    @Delete
    suspend fun delete(result: Car)

//    @Query("SELECT * FROM car WHERE serialNumber = :serialNumber")
//    fun getById(serialNumber: Long): LiveData<Car>

//    @Query("SELECT * FROM car WHERE model LIKE :search OR speed LIKE :search")
//    fun getAllWithModelLikeOrSpeedLike(search: String?): LiveData<List<Car>>

//    return deleteListCount
//    @Query("DELETE from car WHERE serialNumber IN (:serialNumber)")
//    suspend fun deleteByIdList(serialNumber: List<Long>): Int

}