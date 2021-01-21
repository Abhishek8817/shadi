package com.enviroment.shadicom.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.enviroment.shadicom.BaseViewmodel
import com.enviroment.shadicom.model.User

import com.enviroment.shadicom.repository.ProfileRepos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProfileViewModel(application : Application) : BaseViewmodel(application) {
    private lateinit var mJob: Job
    private val mProfieLiveData : MutableLiveData<User> = MutableLiveData<User>()
    private val profileRepos :ProfileRepos =  ProfileRepos()

    fun queryProfileList() {
      mJob =  viewModelScope.launch(Dispatchers.IO) {
          var mUser: User = profileRepos.getProfileList()
          try {
            withContext(Dispatchers.Main) {
              mProfieLiveData.value = mUser
              Log.d("ProfileViewModel", "Value of User : ")
          }
          } catch (e: Exception) {
              Log.d("ProfileViewModel", "Value of User : " + e.message)
          } finally {
          }
        }
    }

    fun getUserProfile(): LiveData<User>{
        return mProfieLiveData
    }

    suspend fun saveData( mUser : User){
//        UserDatabase.getDatabase(mContext).userDao().deleteAll();
//        UserDatabase.getDatabase(mContext).userDao().insert(mUser.results.get(0));
    }

    override fun onCleared() {
        super.onCleared()
        mJob?.let {
            mJob.cancel()
        }
    }
}