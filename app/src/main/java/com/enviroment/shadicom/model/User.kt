package com.enviroment.shadicom.model


import com.enviroment.shadicom.model.bean.UserInfo
import com.enviroment.shadicom.model.bean.UserResult



data class User(
//     @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    val id :Int,
//    @TypeConverters(Converters::class)

      val results : List<UserResult>,
      val info: UserInfo
)
