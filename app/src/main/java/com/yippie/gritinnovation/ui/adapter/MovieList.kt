package com.yippie.gritinnovation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yippie.gritinnovation.R
import com.yippie.gritinnovation.ui.model.Result

class MovieList (val context: Context,val list: ArrayList<Result>):RecyclerView.Adapter<MovieList.MyViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_movielist, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
    return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // internal var tvCountryName: TextView

        init {
        //    tvCountryName = itemView.findViewById(R.id.tv_country_name) as TextView
        }
    }

}