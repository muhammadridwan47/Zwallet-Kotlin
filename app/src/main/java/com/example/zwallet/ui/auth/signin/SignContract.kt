package com.example.zwallet.ui.auth.signin

import com.example.zwallet.base.BasePresenter
import com.example.zwallet.base.BaseView
import com.example.zwallet.model.response.login.Token

interface SignContract {

    interface View: BaseView {
        fun onLoginSuccess(loginResponse: Token)
        fun onLoginFailed(message: String)
    }

    interface Presenter : SignContract, BasePresenter {
        fun submitLogin(email: String, password: String)
    }
}