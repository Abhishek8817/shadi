//package com.enviroment.shadicom.data.db
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.enviroment.shadicom.model.User
//import com.enviroment.shadicom.model.bean.UserResult
//
//
//@Dao
//interface UserDao {
//
//    @Query("SELECT * FROM UserProfile")
//    fun getAlphabetizedWords(): List<UserResult>
//
//    @Insert()
//    suspend fun insert(user: UserResult)
//
//    @Query("DELETE FROM UserProfile")
//    suspend fun deleteAll()
//}