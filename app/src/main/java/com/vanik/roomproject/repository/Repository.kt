package com.vanik.roomproject.repository

import com.vanik.roomproject.MainActivity
import com.vanik.roomproject.db.AppDatabase
import com.vanik.roomproject.entity.*

class Repository(activity: MainActivity) {

    private val db = AppDatabase.getInstance(activity)

    fun insertData() {
        for (passportID in 1..10) {
            val cars = arrayListOf<Car>()
            val carSize = (1..3).random()
            for (carIndex in 1..carSize) {
                val carExtraParameters = CarExtraParameters(CarComfort.ECONOM, false, false)
                val car = Car(0, "mercedes", 200, carExtraParameters, passportID)
                cars.add(car)
            }
            val address = Address("Yerevan", "Komitas")
            val person = Person(
                passportId = passportID,
                name = "Bob",
                address = address,
//                birthday = passportID,
                cars = cars
            )
            db.PersonCarDao().insertCarsAndPerson(cars, person)
        }
    }

    fun deleteCar(userID: String, serialNumber: String) {
        if (serialNumber.isNotEmpty() && userID.isNotEmpty()) {
            val car = Car(
                serialNumber.toLong(),
                "mercedes",
                200,
                CarExtraParameters(CarComfort.ECONOM, false, false),
                userID.toInt()
            )
            db.CarDao().delete(car)
        }
    }

    fun updateCar(userID:String,serialNumber: String) {
        if (serialNumber.isNotEmpty() && userID.isNotEmpty()) {
            val car = Car(
                serialNumber.toLong(),
                "bmw",
                400,
                CarExtraParameters(CarComfort.LUX, true, true),
                userID.toInt()
            )
            db.CarDao().update(car)
        }
    }
}