package com.yippie.gritinnovation.ui.core

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import com.yippie.gritinnovation.ui.model.ApiInterface
import com.yippie.gritinnovation.ui.model.MoviesListModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

 class Intractor(private val mOnGetDatalistener: GetDataContract.onGetDataListener) :GetDataContract.Interactor {



   override fun initRetrofitCall(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val request = retrofit.create<ApiInterface>(ApiInterface::class.java)
        val call = request.getMovieList("popularity.desc","fd75d8c708d418f9ee6280f179e7f399")
        call.enqueue(object : retrofit2.Callback<MoviesListModel> {
            override fun onResponse(call: retrofit2.Call<MoviesListModel>, response: retrofit2.Response<MoviesListModel>
            ) {
                mOnGetDatalistener.onSuccess("List Size: " , response.body() as MoviesListModel)


            }

            override fun onFailure(call: retrofit2.Call<MoviesListModel>, t: Throwable) {
                Log.v("Error", t.message)
                mOnGetDatalistener.onFailure(t.message.toString())
            }
        })
    }




}
