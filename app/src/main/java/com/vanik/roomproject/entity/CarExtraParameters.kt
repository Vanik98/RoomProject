package com.vanik.roomproject.entity

import kotlinx.serialization.Serializable

@Serializable
data class CarExtraParameters(
    var carComfort: CarComfort,
    var abs : Boolean,
    var airConditioner : Boolean
)