package com.example.zwallet.ui.transaction.inputsaldo

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.zwallet.R
import com.example.zwallet.model.response.transaction.inputsaldo.GetDataTransaction
import com.example.zwallet.model.response.transaction.inputsaldo.GetDataTransactionDataClass
import com.example.zwallet.model.response.transaction.searchreceiver.Data
import com.example.zwallet.utils.Helpers.formatPrice
import kotlinx.android.synthetic.main.fragment_input_saldo.*
import kotlinx.android.synthetic.main.list_item_vertical_noprice.*


class InputSaldoFragment : Fragment() {

    var bundle:Bundle?= null
    var amount: Int = 0
    var balanceLeft: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_saldo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var data = arguments?.getParcelable<Data>("data")


        Log.v("Detail Input Saldo ", data.toString())

        nameList.text = data?.fullName
        numberPhone.text = data?.phoneNumber.toString()
        ivResultSaldo.formatPrice(data?.balance.toString())

        val img = "http://192.168.1.8:7000/images/${data?.img}"
        activity?.let {
            Glide.with(it)
                .load(img)
                .into(imgList)
        }


        ivInpuSaldo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                var result: Int = 0
                var ll  = s.toString()

                if (data?.balance != null && !s.toString().isNullOrEmpty() &&  ll.toInt() < data?.balance) {
                   result =  sum(data.balance,s.toString())
                    balanceLeft = result
                }

                if (!s.toString().isNullOrEmpty() ) {
                    amount = ll.toInt()
                    ivResultSaldo.formatPrice(result.toString())
                }

            }
        })

        ivBtnContinue.setOnClickListener {

            if (ivInpuSaldo.text.isNullOrEmpty()) {
                ivInpuSaldo.setError("Required Field")
            }
            if (amount == 0) {
                ivInpuSaldo.setError("value is not valid")
            }else{
                var data = arguments?.getParcelable<Data>("data")
                val balance = data?.balance.toString()
                val note = ivNoteTransaction.text ?: ""

                var dataInput = GetDataTransactionDataClass(
                        id = data?.id,
                        balance = balance.toInt(),
                        fullName = data?.fullName,
                        img = data?.img,
                        phoneNumber =  data?.phoneNumber,
                        note = note.toString(),
                        amount = amount,
                        balanceLeft = balanceLeft
                )

                bundle = bundleOf("data" to dataInput)

                view?.let { Navigation.findNavController(it).navigate(R.id.action_confirmation, bundle) }

            }
        }

    }

    private fun sum(count1: Int,count2: String): Int {
       return count1 - count2.toInt()
    }
}