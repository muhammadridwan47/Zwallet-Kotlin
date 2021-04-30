package com.example.zwallet.ui.home

import com.example.zwallet.base.BasePresenter
import com.example.zwallet.base.BaseView
import com.example.zwallet.model.response.home.HomeResponse

interface HomeContract {

    interface View: BaseView {
        fun onHomeSuccess(homeResponse: HomeResponse)
        fun onHomeFailed(message: String)
    }

    interface Presenter : HomeContract, BasePresenter {
        fun getHome()
    }
}