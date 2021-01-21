package com.enviroment.shadicom.model.bean

import androidx.room.ColumnInfo

data class UserInfo(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)