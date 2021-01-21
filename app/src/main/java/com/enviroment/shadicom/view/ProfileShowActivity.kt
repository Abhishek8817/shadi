package com.enviroment.shadicom.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enviroment.shadicom.R
import com.enviroment.shadicom.model.User
import com.enviroment.shadicom.model.bean.UserResult
import com.enviroment.shadicom.viewmodel.ProfileViewModel

class ProfileShowActivity : AppCompatActivity() {
    private lateinit var mProfileViewModel: ProfileViewModel
    private lateinit var mRvProfile : RecyclerView
    private  lateinit var mList: List<UserResult>
    private lateinit var  mProfileAdapter :  ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiel_show)
        init()
        subscribeToModel()
        mProfileViewModel.queryProfileList()
    }

    fun init(){
        mProfileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        mRvProfile = findViewById(R.id.rv_list)
        mList = mutableListOf();
        var mLinearLayoutManager : LinearLayoutManager = LinearLayoutManager(this)
        mRvProfile.layoutManager = mLinearLayoutManager
    }

    fun setAdapter(mUserList: List<UserResult>){
        mProfileAdapter = ProfileAdapter(mUserList)
        mRvProfile.adapter = mProfileAdapter
    }

    fun subscribeToModel() {
        mProfileViewModel.getUserProfile().observe(this, Observer {
            setAdapter(it.results)
            });
    }



}
