package com.vanik.roomproject.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
    @PrimaryKey val serialNumber: Long,
    var model: String,
    var speed: Int,
//    var complectation: Complectation
)


//embedded
//TypeConverters

//   - gson
//   - kotlinx serialization (actual)

//keep List<Int>
//keep List<Any>

//   - gson
//   - kotlinx serialization (actual)

