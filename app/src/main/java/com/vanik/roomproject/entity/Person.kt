package com.vanik.roomproject.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey val passportId: Int,
    val name: String,
    @Embedded(prefix = "address") val address: Address,
    var cars: List<Car>,
//    var birthday:Int
)