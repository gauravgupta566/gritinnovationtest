package com.yippie.gritinnovation.ui.core

import com.yippie.gritinnovation.ui.model.MoviesListModel

class Presenter(private val mGetDataView: GetDataContract.View) : GetDataContract.Presenter,
    GetDataContract.onGetDataListener {

    override fun onSuccess(message: String, result: MoviesListModel) {
        mGetDataView.onGetDataSuccess(message, result)
    }

    private val mIntractor: Intractor

    init {
        mIntractor = Intractor(this)
    }



    override fun getDataFromURL() {
        mIntractor.initRetrofitCall()
    }


   override fun onFailure(message: String) {
        mGetDataView.onGetDataFailure(message)
    }
}
