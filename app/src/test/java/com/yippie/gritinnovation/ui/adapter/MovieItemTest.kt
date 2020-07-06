package com.yippie.gritinnovation.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.nhaarman.mockito_kotlin.any
import com.yippie.gritinnovation.ui.model.Result
import org.json.JSONObject
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
class MovieItemTest {


    lateinit var movieItem: MovieItem
    lateinit var list: ArrayList<Result>

    @Mock
    lateinit var viewGroup: ViewGroup

    @Mock
    lateinit var holder: MovieItem.MyViewHolder



    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        holder=PowerMockito.mock(MovieItem.MyViewHolder::class.java)
        movieItem= MovieItem(list)

    }


    @Test(expected = NullPointerException::class)
    fun onCreateViewHolderWithBull(){

        var a="aaa"
        movieItem.onCreateViewHolder(a as ViewGroup, any())
    }

    @Test()
    fun onCreateViewHolder(){

         viewGroup= PowerMockito.mock(ViewGroup::class.java)
        movieItem.onCreateViewHolder(viewGroup, any())
    }

    @Test()
    fun onBindViewCalled(){

        addJson()
        movieItem.onBindViewHolder(holder, 0)
    }


    @Test
    fun getItemCount(){
        Assert.assertEquals(0,movieItem.itemCount)
        addJson()
        Assert.assertEquals(1,movieItem.itemCount)

    }

    private fun addJson() {
        val mutableListlist= listOf(1,2,3)
        val result=Result(false,"",mutableListlist,5,"","","",
            24.5,"","","",false,23.5,10)
        list.add(result)

    }


}

