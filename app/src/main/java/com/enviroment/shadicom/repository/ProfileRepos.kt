package com.enviroment.shadicom.repository

import com.enviroment.shadicom.data.ApiClient
import com.enviroment.shadicom.model.User

class ProfileRepos {

    suspend fun getProfileList(): User {
        return ApiClient.getUser().getProfileList("20")
    }


}