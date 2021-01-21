//package com.enviroment.shadicom.data.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//import com.enviroment.shadicom.model.User
//import com.enviroment.shadicom.model.bean.UserResult
//
//
//@Database(entities = arrayOf(UserResult::class), version = 1, exportSchema = false)
//public abstract class UserDatabase : RoomDatabase() {
//
//   abstract fun userDao(): UserDao
//
//   companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: UserDatabase? = null
//
//        fun getDatabase(context: Context): UserDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        UserDatabase::class.java,
//                        "UserProfile"
//                    ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//   }
//}