package com.vanik.roomproject.data.roomdb

import androidx.room.TypeConverter
import com.vanik.roomproject.entity.Car
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