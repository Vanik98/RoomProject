package com.vanik.roomproject.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

//https://startandroid.ru/ru/courses/architecture-components/27-course/architecture-components/530-urok-6-room-entity.html

@Entity(
    foreignKeys = [ForeignKey(
        entity = Car::class,
        parentColumns = ["passportId"],
        childColumns = ["serialNumber"],
        onDelete = CASCADE
    )]
)
data class Person(
    @PrimaryKey(autoGenerate = true)
    val passportId: String,
    val name: String,
    val cars: List<Car>
)