package com.vanik.roomproject.data.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.Person


@Dao
abstract class PersonCarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPerson(person: Person)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCar(car: Car)

    @Transaction
    open suspend fun insertCarsAndPerson(cars: List<Car>, person: Person) {
        insertPerson(person)
        for (car in cars) {
            insertCar(car)
        }
    }
}