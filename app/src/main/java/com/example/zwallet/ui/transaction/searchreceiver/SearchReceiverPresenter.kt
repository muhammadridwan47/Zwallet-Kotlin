package com.example.zwallet.ui.transaction.searchreceiver
import com.example.zwallet.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchReceiverPresenter(private val view:SearchReceiverContract.View  ) : SearchReceiverContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun getUsers(params : String) {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.getUsers(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view.dismissLoading()
                            if (it.message == "Success get all user data") {
                                view.onSearchSuccess(it)
                            } else {
                                it.message?.let { it1 -> view.onSearchFailed(it1) }
                            }
                        }
//                        ,
//                        {
//                            view.dismissLoading()
//                            view.onSearchFailed(it.message.toString())
//                        }
                )
        mCompositeDisposable!!.add(disposable)
    }

    override fun subcribe() {

    }

    override fun unSubcribe() {
        mCompositeDisposable!!.clear()
    }


}