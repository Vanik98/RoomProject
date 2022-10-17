package com.vanik.roomproject.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(
    foreignKeys = [ForeignKey(
        entity = Person::class,
        parentColumns = ["passportId"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Car (
    @PrimaryKey(autoGenerate = true) val serialNumber: Long,
    var model: String,
    var speed: Int,
    @Embedded var carExtraParameters: CarExtraParameters,
    var userId:Int,
)
