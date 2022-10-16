package com.vanik.roomproject.entity

import androidx.room.Ignore

class Address(
    val city: String,
    val street: String,
    @Ignore val location:String
)