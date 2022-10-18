package com.vanik.roomproject.entity

import androidx.room.Ignore
@kotlinx.serialization.Serializable
data class Address(
    val city: String,
    val street: String
)