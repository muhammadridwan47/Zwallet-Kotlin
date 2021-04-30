package com.example.zwallet.ui.transaction.pinconfirmation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.zwallet.R
import com.example.zwallet.model.response.transaction.inputsaldo.GetDataTransactionDataClass
import com.example.zwallet.model.response.transaction.pinconfirmation.Data
import kotlinx.android.synthetic.main.fragment_pin_confirmation.*


class PinConfirmationFragment : Fragment(), PinConfirmationContract.View {

    private lateinit var presenter: PinConfirmationPresenter
    var bundle:Bundle?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pin_confirmation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = PinConfirmationPresenter(this)

        var data = arguments?.getParcelable<GetDataTransactionDataClass>("data")

        Log.v("tamvan pinconfirmation",data.toString())

        ivBtnTransfer.setOnClickListener {
            val pin1 = ivPin1.text
            val pin2 = ivPin2.text
            val pin3 = ivPin3.text
            val pin4 = ivPin4.text
            val pin5 = ivPin5.text
            val pin6 = ivPin6.text

            if (pin1.isNullOrEmpty()) {
                ivPin1.setError("Required Field")
            }
            if (pin2.isNullOrEmpty()) {
                ivPin2.setError("Required Field")
            }
            if (pin3.isNullOrEmpty()) {
                ivPin3.setError("Required Field")
            }
            if (pin4.isNullOrEmpty()) {
                ivPin4.setError("Required Field")
            }
            if (pin5.isNullOrEmpty()) {
                ivPin5.setError("Required Field")
            }
            if (pin6.isNullOrEmpty()) {
                ivPin6.setError("Required Field")
            }

            if (!pin1.isNullOrEmpty() && !pin2.isNullOrEmpty() && !pin3.isNullOrEmpty() && !pin4.isNullOrEmpty() && !pin5.isNullOrEmpty() && !pin6.isNullOrEmpty()){
                val concat = "$pin1$pin2$pin3$pin4$pin5$pin6".toInt()
                data?.let {
                    presenter.transaction(
                        receiver = it.id!!,
                        status = "Transfer",
                        note = it.note ?: "",
                        amountTransfer = it.amount ?: 0,
                        balanceLeft = it.balanceLeft ?: 0,
                        pin = concat,
                    )
                }
            }
        }

    }

    override fun onPinConfiramtionSuccess(pinConfirmationResponse: Data) {
       Log.v("tamvan confir sucess ",pinConfirmationResponse.toString())

        var data = arguments?.getParcelable<GetDataTransactionDataClass>("data")
        bundle = bundleOf("data" to data)
        view?.let { Navigation.findNavController(it).navigate(R.id.action_status_transfer, bundle) }
    }

    override fun onPinConfiramtionFailed(message: String) {
        Log.v("tamvan confir Failed ",message)
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

}