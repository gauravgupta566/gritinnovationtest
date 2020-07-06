package com.yippie.gritinnovation.ui.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("3/discover/movie")
    abstract fun getMovieList(@Query("sort_by") sort_by:String,@Query("api_key") api_key:String): Call<MoviesListModel>

    /*
    *
    * https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=fd75d8c708d418f9ee6280f179e7f399
    * */
}