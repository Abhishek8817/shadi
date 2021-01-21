package com.enviroment.shadicom.data

import com.enviroment.shadicom.utils.Constant
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        val client = OkHttpClient.Builder().build()

        fun getClient(): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client)
                .build()
            return retrofit
        }

        fun getUser(): UserApi {
            val retrofit: Retrofit = getClient()
            val mUserAPiUserApi = retrofit.create(UserApi::class.java)
            return mUserAPiUserApi
        }

    }
}