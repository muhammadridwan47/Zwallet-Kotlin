package com.example.zwallet.ui.transaction.pinconfirmation

import com.example.zwallet.base.BasePresenter
import com.example.zwallet.base.BaseView
import com.example.zwallet.model.response.transaction.pinconfirmation.Data

interface PinConfirmationContract {

    interface View: BaseView {
        fun onPinConfiramtionSuccess(pinConfirmationResponse: Data)
        fun onPinConfiramtionFailed(message: String)
    }

    interface Presenter : PinConfirmationContract, BasePresenter {
        fun transaction(
            receiver: Int,
            status : String,
            note : String,
            amountTransfer: Int,
            balanceLeft: Int,
             pin: Int
        )
    }
}