package com.enviroment.shadicom.view

import android.R.id.message
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.enviroment.shadicom.R
import com.enviroment.shadicom.model.bean.UserResult
import java.util.*


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
        var btnAccept: Button = itemView.findViewById(R.id.btn_accept)
        var btnDecline: Button = itemView.findViewById(R.id.btn_decline)
        var tvAddress: TextView = itemView.findViewById(R.id.tv_address)
        var tvMail: TextView = itemView.findViewById(R.id.tv_mail)
    }


    fun bindDataLayout(holder: UserViewHolder, position: Int){
        var userResult : UserResult = mProfileList.get(position)
        holder.tvName.text = userResult.name.first +" "+ userResult.name.last
        holder.tvLocation.text = userResult.location.city + " , "+ userResult.location.state
       holder.tvCountry.text = userResult.location.country


        holder.btnAccept.setOnClickListener(View.OnClickListener {
            Toast.makeText(mContext, "Accept", Toast.LENGTH_SHORT).show()
        })
        holder.btnDecline.setOnClickListener(View.OnClickListener {
        Toast.makeText(mContext, "Decline", Toast.LENGTH_SHORT).show()
        })
        holder.tvAddress.setOnClickListener(View.OnClickListener {
            openLoc(userResult.location.coordinates.latitude, userResult.location.coordinates.longitude)
        })
        holder.tvMail.setOnClickListener(View.OnClickListener {
            sendEmail(userResult.email);
        })

        Glide.with(mContext)
                .load(userResult.picture.large)
                .centerInside()
                .circleCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivProfile);
    }

    private fun sendEmail(recipient: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_TEXT, message)
        mIntent.setPackage("com.google.android.gm");
        try {
            mContext.startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        } catch (e: Exception){
            Toast.makeText(mContext, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun openLoc(lat : String , long : String){
        val uri = java.lang.String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%s,%s", lat, long)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        mContext.startActivity(intent)
    }

}