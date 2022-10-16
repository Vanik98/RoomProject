package com.vanik.roomproject.db

import androidx.room.TypeConverter
import com.vanik.roomproject.entity.Complectation
import com.vanik.roomproject.entity.Type

class DataConverter {
    @TypeConverter
    fun fromComplectation(type: Type, abs:Boolean, airConditioner:Boolean): Complectation {
        return Complectation(type,abs,airConditioner)
    }

    @TypeConverter
    fun stringToComplectation(complectation: Complectation): String {
        return complectation.type.toString()+complectation.abs.toString()+complectation.airConditioner.toString()
    }
}