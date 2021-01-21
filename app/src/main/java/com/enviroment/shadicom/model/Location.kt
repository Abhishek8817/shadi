package com.enviroment.shadicom.model.bean

import androidx.room.ColumnInfo

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
//    val postcode: Int,
    val coordinates: Coordinates,
    val timezone: TimeZone
)