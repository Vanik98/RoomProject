package com.vanik.roomproject.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Car::class,
        parentColumns = ["passportId"],
        childColumns = ["serialNumber"],
        onDelete = CASCADE
    )]
)
data class Person(
    @PrimaryKey(autoGenerate = true) val passportId: String,
    val name: String,
    @Embedded(prefix = "address") val address: Address,
    var cars: List<Car>
)