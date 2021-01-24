package com.enviroment.shadicom.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.enviroment.shadicom.R
import com.enviroment.shadicom.model.bean.UserResult
import org.w3c.dom.Text

class ProfileAdapter(mProfileList: List<UserResult>, mContext : Context) : RecyclerView.Adapter<ProfileAdapter.UserViewHolder>() {
    private lateinit var mProfileList : List<UserResult> ;
    private lateinit var mContext: Context;

    init {
        this.mProfileList = mProfileList
        this.mContext = mContext;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View =LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent , false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
       return mProfileList.count();
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        bindDataLayout(holder , position)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ivProfile: ImageView = itemView.findViewById(R.id.iv_view)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_loc)
        var tvCountry: TextView = itemView.findViewById(R.id.tv_country)



    }


    fun bindDataLayout(holder: UserViewHolder, position: Int){
        var userResult : UserResult = mProfileList.get(position)
        holder.tvName.text = userResult.name.first +" "+ userResult.name.last
        holder.tvLocation.text = userResult.location.city + " , "+ userResult.location.state
        holder.tvCountry.text = userResult.location.country

        Glide.with(mContext)
                .load(userResult.picture.large)
                .centerInside()
                .circleCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivProfile);
    }


}