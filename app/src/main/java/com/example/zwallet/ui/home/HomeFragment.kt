package com.example.zwallet.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.zwallet.R
import com.example.zwallet.Zwallet
import com.example.zwallet.model.response.home.DataTransfer
import com.example.zwallet.model.response.home.HomeResponse
import com.example.zwallet.model.response.home.Result
import com.example.zwallet.ui.auth.AuthActivity
import com.example.zwallet.ui.topup.TopUpActivity
import com.example.zwallet.ui.transaction.TransactionActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

//    private var dataList = ArrayList<HomeModel>()
    private var dataList:  ArrayList<DataTransfer> = ArrayList()
    private var result = ArrayList<Result>()

    private lateinit var presenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val token = Zwallet.getApp().getToken()

        if (token != null) {
            Zwallet.getApp().setToken(token)
            presenter = HomePresenter(this)
            presenter.getHome()
        }

        ivIcon.setOnClickListener {
            Zwallet.getApp().setToken("")

            startActivity(Intent(activity,AuthActivity::class.java))
            activity?.finish()
        }

        btnTransaction.setOnClickListener {
            startActivity(Intent(activity,TransactionActivity::class.java))
        }

        btnTopup.setOnClickListener {
            startActivity(Intent(activity,TopUpActivity::class.java))
        }


//        dataList.add(
//            HomeModel(
//                1,
//                "Muhammad Riduwan",
//                "Transfer",
//                50000,
//                R.drawable.arung
//            )
//        )
//
//        dataList.add(
//            HomeModel(
//                1,
//                "Komang James",
//                "Transfer",
//                50000,
//                R.drawable.arung
//            )
//        )
//
//        dataList.add(
//            HomeModel(
//                1,
//                "Andre Taulani",
//                "Transfer",
//                50000,
//                R.drawable.arung
//            )
//        )

//        recylcleItemList.adapter = HomeAdapter(dataList) {
//
//        }

    }

    override fun onHomeSuccess(homeResponse: HomeResponse) {
//        Log.v("Tamvan: Home => ", homeResponse.data.result[0].balance.toString())

//        dataList.add(homeResponse.data.data)

        for(x in homeResponse.data.data) {
//            Log.v("tamvan For ", x.toString())
            dataList.add(x)
        }


        result.add(homeResponse.data.result[0])
//        Log.v("tamvan result: ", result[0].fullName)

        ivBalance.text = "Rp${result[0].balance}"
        ivName.text = result[0].fullName
        ivPhone.text = "+${result[0].phoneNumber}"

        if (!result[0].img.isNullOrEmpty()) {
            val img = "http://192.168.1.8:7000/images/${result[0].img}"
            Glide.with(requireContext())
                .load(img)
                .into(ivProfile)


        }


        recylcleItemList.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        recylcleItemList.adapter = HomeAdapter(dataList) {

        }

    }

    override fun onHomeFailed(message: String) {
//        Log.v("Tamvan: HomeFailed => ", message)
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }
}