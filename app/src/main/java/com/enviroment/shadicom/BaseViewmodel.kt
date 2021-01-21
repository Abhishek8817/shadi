package com.enviroment.shadicom

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

open class BaseViewmodel(application : Application) : AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    protected var mContext : Context = getApplication<Application>().applicationContext



}