package com.yippie.gritinnovation.ui.core

import android.content.Context
import com.yippie.gritinnovation.ui.model.MoviesListModel

interface GetDataContract {

    interface View {
        fun onGetDataSuccess(message: String, result: MoviesListModel)
        fun onGetDataFailure(message: String)
    }

    interface Presenter {
        fun getDataFromURL()
    }

    interface Interactor {
        fun initRetrofitCall()

    }

    interface onGetDataListener {
        fun onSuccess(message: String, result: MoviesListModel)
        fun onFailure(message: String)
    }

}