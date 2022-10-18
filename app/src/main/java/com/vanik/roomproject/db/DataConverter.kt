package com.vanik.roomproject.db

import androidx.room.TypeConverter
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.CarComfort
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DataConverter {

    @TypeConverter
    fun fromCarsList(str: String): List<Car> {
        return Json.decodeFromString(str)
    }

    @TypeConverter
    fun stringToCarsList(cars: List<Car>): String {
        return Json.encodeToString(cars)
    }

}