package com.vanik.roomproject.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    @PrimaryKey(autoGenerate = true)
    val passportId:String,
    val name:String,
    val cars: List<Car>
        )