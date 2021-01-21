package com.enviroment.shadicom.data

import com.enviroment.shadicom.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("api/")
    suspend fun getProfileList(@Query("results") numer: String): User

}