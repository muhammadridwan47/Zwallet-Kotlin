package com.example.zwallet.ui.transaction.searchreceiver

import com.example.zwallet.base.BasePresenter
import com.example.zwallet.base.BaseView
import com.example.zwallet.model.response.transaction.searchreceiver.SearchReceiverResponse

interface SearchReceiverContract {

    interface View: BaseView {
        fun onSearchSuccess(homeResponse: SearchReceiverResponse)
        fun onSearchFailed(message: String)
    }

    interface Presenter : SearchReceiverContract, BasePresenter {
        fun getUsers(params: String)
    }
}