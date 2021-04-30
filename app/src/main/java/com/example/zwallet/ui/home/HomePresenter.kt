package com.example.zwallet.ui.home

import com.example.zwallet.model.response.home.HomeResponse
import com.example.zwallet.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val view:HomeContract.View  ) : HomeContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun getHome() {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.home()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view.dismissLoading()
                            if (it.success.equals(true)) {
                                    view.onHomeSuccess(it)
//                                it.?.let { it1 -> view.onHomeSuccess(it1) }
                            } else {

//                                it.message?.let { it1 -> view.onHomeFailed(it1) }
                            }
                        },
                        {
                            view.dismissLoading()
                            view.onHomeFailed(it.message.toString())
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