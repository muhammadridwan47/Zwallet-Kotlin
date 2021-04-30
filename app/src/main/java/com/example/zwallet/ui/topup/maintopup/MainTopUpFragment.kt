package com.example.zwallet.ui.topup.maintopup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zwallet.R
import com.example.zwallet.model.response.topup.TopUpResponse
import kotlinx.android.synthetic.main.fragment_main_top_up.*

class MainTopUpFragment : Fragment() {
    private var dataList = ArrayList<TopUpResponse>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_top_up, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        dataList.add(
            TopUpResponse(
                1,
                "Go to the nearest ATM or you can \n" +
                        "use E-Banking."
            )
        )

        dataList.add(
            TopUpResponse(
                2,
                "Type your security number on the\n" +
                        "ATM or E-Banking."
            )
        )

        dataList.add(
            TopUpResponse(
                3,
                "Select “Transfer” in the menu"
            )
        )

        dataList.add(
            TopUpResponse(
                4,
                "Type the virtual account number that\n" +
                        "we provide you at the top."
            )
        )

        dataList.add(
            TopUpResponse(
                5,
                "Type the amount of the money you\n" +
                        "want to top up."
            )
        )

        dataList.add(
            TopUpResponse(
                6,
                "Read the summary details"
            )
        )

        dataList.add(
            TopUpResponse(
                7,
                "Press transfer / top up"
            )
        )

        dataList.add(
            TopUpResponse(
                8,
                "You can see your money in Zwallet\n" +
                        "within 3 hours."
            )
        )
        
        rcTopup.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        rcTopup.adapter = TopUpAdapter(dataList) {
            
        }
    }

}