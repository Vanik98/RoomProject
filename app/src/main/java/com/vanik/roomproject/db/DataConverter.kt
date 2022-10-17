package com.vanik.roomproject.db

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.CarComfort
import com.vanik.roomproject.entity.CarExtraParameters
import java.io.*
import java.util.*

class DataConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromCarsList(str: String): List<Car> {
        return fromString(str) as List<Car>
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun stringToCarsList(cars: List<Car>): String {
        var str = ""
        for (car in cars) {
            str += toString(car)
        }
        return str
    }

    @TypeConverter
    fun toComfort(value: String) = enumValueOf<CarComfort>(value)

    @TypeConverter
    fun fromComfort(value: CarComfort) = value.name

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(IOException::class, ClassNotFoundException::class)
    private fun fromString(s: String): Any? {
        val data: ByteArray = Base64.getDecoder().decode(s)
        val ois = ObjectInputStream(
            ByteArrayInputStream(data)
        )
        val o: Any = ois.readObject()
        ois.close()
        return o
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(IOException::class)
    private fun toString(o: Serializable): String {
        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(o)
        oos.close()
        return Base64.getEncoder().encodeToString(baos.toByteArray())
    }
}