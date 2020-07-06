package com.yippie.gritinnovation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ReportFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.yippie.gritinnovation.R
import com.yippie.gritinnovation.ui.core.GetDataContract
import com.yippie.gritinnovation.ui.model.MoviesListModel
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import java.util.logging.Handler

@RunWith(PowerMockRunner::class)
@PrepareForTest(
    ReportFragment::class,
    View::class,
    FragmentActivity::class,
    AppCompatActivity::class
)

class MainActivityTest {

    lateinit var mainActivity: MainActivity

    @Mock
    lateinit var result:MoviesListModel

    @Mock
    lateinit var listener: GetDataContract.onGetDataListener

    @Mock
    lateinit var bundle: Bundle

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockStatic(ReportFragment::class.java)
        mockStatic(View::class.java)

        mainActivity= PowerMockito.mock(MainActivity::class.java)
        result=PowerMockito.mock(MoviesListModel::class.java)
        bundle=PowerMockito.mock(Bundle::class.java)
    }

    @Test()
    fun successMethodCalled(){
        PowerMockito.doReturn(listener.onSuccess("",result)).`when`(mainActivity.onGetDataSuccess(
            any(), any()))

        mainActivity.onGetDataSuccess("",result)
    }

    @Test()
    fun failMethodCalled(){
        PowerMockito.doReturn(listener.onFailure("fail")).`when`(mainActivity.onGetDataSuccess(
            any(), any()))


        mainActivity.onGetDataFailure("")
    }

    @Test()
    fun onCreateMethodcalled(){
        val method =
            MainActivity::class.java!!.getDeclaredMethod("onCreate")
        method.setAccessible(true)
        method.invoke(mainActivity)
        PowerMockito.doNothing().`when`(mainActivity.init())
        verify(mainActivity, times(1)).setContentView(R.layout.activity_main)

    }
    @Test()
    fun initMethidCalled(){


    }



}