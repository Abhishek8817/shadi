//package com.enviroment.shadicom.data
//
//import androidx.room.TypeConverter
//import com.enviroment.shadicom.model.bean.UserResult
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//
//class Converters {
//
//    companion object {
//
//        @TypeConverter
//        fun fromString(value: String): List<UserResult> {
//            val listType = object : TypeToken<List<UserResult>>() {}.type
//            return Gson().fromJson(value, listType)
//        }
//
//        @TypeConverter
//        fun fromListList(list: List<UserResult>): String {
//            val gson = Gson()
//            return gson.toJson(list)
//        }
//
//    }
//
//}