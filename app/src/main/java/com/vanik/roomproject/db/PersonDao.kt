package com.vanik.roomproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM car")
    fun getAll(): List<Car>

    @Insert
    fun insert(person: Person)
}