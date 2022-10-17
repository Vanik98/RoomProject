package com.vanik.roomproject.db

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.CarComfort
import com.vanik.roomproject.entity.CarExtraParameters
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.json.JSONObject
import java.io.*
import java.lang.reflect.Field
import java.util.*

class DataConverter {

    @TypeConverter
    fun fromCarsList(str: String): List<Car> {
        val cars : List<Car> = Json.decodeFromString(str)
        return cars
    }

    @TypeConverter
    fun stringToCarsList(cars: List<Car>): String {
        var str = ""
//        for (car in cars) {
//            str += Json.encodeToString(cars)
//        }
        str = Json.encodeToString(cars)
        return str
    }

    @TypeConverter
    fun toComfort(value: String) = enumValueOf<CarComfort>(value)

    @TypeConverter
    fun fromComfort(value: CarComfort) = value.name

}