package com.vanik.roomproject.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Person(
    @PrimaryKey val passportId: Int,
    val name: String,
    @Embedded(prefix = "address") val address: Address,
    var cars: List<Car>,
//    var birthday:Int
)