package com.yippie.gritinnovation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.yippie.gritinnovation.R
import com.yippie.gritinnovation.ui.adapter.MovieItem
import com.yippie.gritinnovation.ui.core.GetDataContract
import com.yippie.gritinnovation.ui.core.Presenter
import com.yippie.gritinnovation.ui.model.MoviesListModel
import com.yippie.gritinnovation.ui.model.Result
import com.yippie.gritinnovation.ui.utils.VerticalSpaceItemDecoration

class MainActivity : AppCompatActivity(), GetDataContract.View {

    private  var mPresenter: Presenter? = null
    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var movieItemAdapter:MovieItem

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        init()



    }

    public fun init() {
        mPresenter = Presenter(this)
        mPresenter?.getDataFromURL()
        recyclerView = findViewById(R.id.recycler) as RecyclerView
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        val spacing =Singleton.dpToPx(10)
        recyclerView.addItemDecoration( VerticalSpaceItemDecoration(spacing))
    }


    override fun onGetDataSuccess(message: String, result: MoviesListModel) {

        movieItemAdapter=MovieItem(result.results as ArrayList<Result>)
        recyclerView.adapter = movieItemAdapter

    }

    override fun onGetDataFailure(message: String) {

        Toast.makeText(this@MainActivity,"something wrong",Toast.LENGTH_LONG).show()

    }



}