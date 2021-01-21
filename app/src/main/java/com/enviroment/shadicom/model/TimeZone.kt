package com.enviroment.shadicom.model.bean

import androidx.room.ColumnInfo

data class TimeZone(
    val offset: String,
    val description: String
)