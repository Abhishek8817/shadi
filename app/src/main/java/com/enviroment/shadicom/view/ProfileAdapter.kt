package com.enviroment.shadicom.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enviroment.shadicom.R
import com.enviroment.shadicom.model.bean.UserResult

class ProfileAdapter(mProfileList: List<UserResult>) : RecyclerView.Adapter<ProfileAdapter.UserViewHolder>() {
   private lateinit var mProfileList : List<UserResult> ;

    init {
        this.mProfileList = mProfileList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View =LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent , false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
       return mProfileList.count();
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       var userResult : UserResult = mProfileList.get(position)
        holder.tvname.text = userResult.name.first;
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvname: TextView = itemView.findViewById(R.id.tv_name)
    }
}