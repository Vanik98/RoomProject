package com.vanik.roomproject.repository

import com.vanik.roomproject.MainActivity
import com.vanik.roomproject.db.AppDatabase
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.Person

class Repository(activity: MainActivity) {

    private val db = AppDatabase.getInstance(activity)

    fun insertData() {
        for (i in 1..10) {
            val cars = arrayListOf<Car>()
            val carSize = (1..10).random()
            for (carIndex in 1..carSize) {
                var serialNumber: Long = (carIndex * 10000000).toLong()
                val car = Car(serialNumber, "mercedes", 200)
                cars.add(car)
            }
            val person = Person("", name = "Bob", cars = cars)
            db.PersonDao().insert(person)
        }
    }

    fun deleteCar(serialNumberEditText: String) {
        if (serialNumberEditText.isNotEmpty()) {
            val serialNumber: Long = (serialNumberEditText.toInt() * 10000000).toLong()
            val car = Car(serialNumber, "mercedes", 200)
            db.CarDao().delete(car)
        }
    }

    fun updateCar(serialNumberEditText: String) {
        if (serialNumberEditText.isNotEmpty()) {
            val serialNumber: Long = (serialNumberEditText.toInt() * 10000000).toLong()
            val car = Car(serialNumber, "mercedes", 300)
            db.CarDao().update(car)
        }
    }
}