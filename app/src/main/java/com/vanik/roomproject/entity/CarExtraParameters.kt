package com.vanik.roomproject.entity

import java.io.Serializable

data class CarExtraParameters(
    var carComfort: CarComfort,
    var abs : Boolean,
    var airConditioner : Boolean
) : Serializable