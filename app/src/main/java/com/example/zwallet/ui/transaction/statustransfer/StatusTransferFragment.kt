package com.example.zwallet.ui.transaction.statustransfer

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.zwallet.R
import com.example.zwallet.model.response.transaction.inputsaldo.GetDataTransactionDataClass
import com.example.zwallet.ui.MainActivity
import com.example.zwallet.utils.Helpers
import kotlinx.android.synthetic.main.fragment_status_transfer.*
import kotlinx.android.synthetic.main.list_item_vertical_noimage.view.*
import kotlinx.android.synthetic.main.list_item_vertical_noprice.view.*
import kotlinx.android.synthetic.main.list_item_vertical_noprice.view.nameList


class StatusTransferFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status_transfer, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var data = arguments?.getParcelable<GetDataTransactionDataClass>("data")


        Log.v("tamvan confirmation: ", data.toString())

        Log.v("tamnvan balance ", data?.balance.toString())

        includeProfile.nameList.text = data?.fullName
        includeProfile.numberPhone.text = data?.phoneNumber.toString()

        val img = "http://192.168.1.8:7000/images/${data?.img}"
        activity?.let {
            Glide.with(it)
                .load(img)
                .into(includeProfile.imgList)
        }

        includeAmount.nameList.text = "Amount"
        includeAmount.priceList.text = data?.amount.toString()

        includeBalanceLeft.nameList.text = "Balance Left"
        includeBalanceLeft.priceList.text = data?.balanceLeft.toString()

        includeDate.nameList.text = "Date & Time"
        includeDate.priceList.text = Helpers.formatDateNow()


        includeNotes.nameList.text = "Notes"
        includeNotes.priceList.text = data?.note

        ivBtnContinue.setOnClickListener {
            activity?.finish()
        }
    }


}