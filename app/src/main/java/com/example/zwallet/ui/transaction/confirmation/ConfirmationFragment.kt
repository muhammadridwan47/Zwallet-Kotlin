package com.example.zwallet.ui.transaction.confirmation

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
import com.example.zwallet.model.response.transaction.searchreceiver.Data
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.list_item_vertical_noimage.*
import kotlinx.android.synthetic.main.list_item_vertical_noimage.view.*
import kotlinx.android.synthetic.main.list_item_vertical_noprice.view.*
import kotlinx.android.synthetic.main.list_item_vertical_noprice.view.nameList
import com.example.zwallet.utils.Helpers.formatDateNow
import kotlinx.android.synthetic.main.list_item_vertical_noimage.nameList
import kotlinx.android.synthetic.main.list_item_vertical_noprice.*

class ConfirmationFragment : Fragment() {

    var bundle:Bundle?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
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
        includeDate.priceList.text =  formatDateNow()


        includeNotes.nameList.text = "Notes"
        includeNotes.priceList.text = data?.note

        ivBtnContinue.setOnClickListener {
            bundle = bundleOf("data" to data)

            view?.let { Navigation.findNavController(it).navigate(R.id.action_pin_confirmation, bundle) }

        }
    }
}