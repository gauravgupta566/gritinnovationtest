package com.yippie.gritinnovation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yippie.gritinnovation.R
import com.yippie.gritinnovation.ui.model.Result

class MovieItem (val list: ArrayList<Result>): RecyclerView.Adapter<MovieItem.MyViewHolder>()  {


    val c=100

    fun cal(a:Int,b:Int)=a*b

    fun sum(a:Int,b:Int):Int{
        return a+b
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_movie_details, parent, false)

        val cc=cal(12,23)
        val value=sum(100,230)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        
        holder.bindItems(list[position])
    }



    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        
        
        fun bindItems(result: Result) {
            val movieName = itemView.findViewById(R.id.titleMovie) as TextView
            val releaseDate  = itemView.findViewById(R.id.releaseDate) as TextView
            val movieDescription  = itemView.findViewById(R.id.movieDescription) as TextView
            val movieRating  = itemView.findViewById(R.id.movieRating) as TextView

            movieName.text = result.original_title
            releaseDate.text = result.release_date
            movieDescription.text = result.overview
            movieRating.text = result.vote_average.toString()


        }
    }

}