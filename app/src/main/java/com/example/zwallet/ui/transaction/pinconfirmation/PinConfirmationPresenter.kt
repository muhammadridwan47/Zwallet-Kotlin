package com.example.zwallet.ui.transaction.pinconfirmation
import com.example.zwallet.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PinConfirmationPresenter(private val view:PinConfirmationContract.View  ) : PinConfirmationContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun transaction(
        receiver: Int,
        status : String,
        note : String,
        amountTransfer: Int,
        balanceLeft: Int,
        pin: Int
    ) {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.transaction(
                25,
                "Transfer",
                "Beli Sendal",
                3000,
                2000,
                111111)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view.dismissLoading()
                            if (it.message == "Success Create Transaction") {
                                view.onPinConfiramtionSuccess(it.data)
                            } else {
                                it.message?.let { it1 -> view.onPinConfiramtionFailed(it1) }
                            }
                        }
                       ,
                        {
                            view.dismissLoading()
                            view.onPinConfiramtionFailed(it.message.toString())
                        }
                )
        mCompositeDisposable!!.add(disposable)
    }

    override fun subcribe() {

    }

    override fun unSubcribe() {
        mCompositeDisposable!!.clear()
    }


}