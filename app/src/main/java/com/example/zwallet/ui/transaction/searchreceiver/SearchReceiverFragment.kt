package com.example.zwallet.ui.transaction.searchreceiver

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zwallet.R
import com.example.zwallet.model.response.transaction.searchreceiver.Data
import com.example.zwallet.model.response.transaction.searchreceiver.SearchReceiverResponse
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search_receiver.*

class SearchReceiverFragment() : Fragment(),SearchReceiverAdapter.ItemAdapterCallback,SearchReceiverContract.View {

    private lateinit var presenter: SearchReceiverPresenter
    private var dataList:  ArrayList<Data> = ArrayList()

    var bundle:Bundle?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_receiver, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = SearchReceiverPresenter(this)

        presenter.getUsers("")
        ivSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Log.v("tamvan result change: ", s.toString())
                presenter.getUsers(s.toString())
            }
        })
    }

    override fun onSearchSuccess(searchResponse: SearchReceiverResponse) {
        dataList.clear()
        Log.v("tamvan result success: ", searchResponse.toString())

        for(x in searchResponse.data) {
//            Log.v("tamvan For ", x.toString())
            dataList.add(x)
        }

        ivCount.text = "${dataList.size} Contact Founds"
        rvTransfer.adapter = SearchReceiverAdapter(dataList,this)
        rvTransfer.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)


    }

    override fun onSearchFailed(message: String) {
            Log.v("tamvan result failed: ",message)
            ivCount.text = "0 Contact Founds"
            Log.v("when ksong: ", dataList.toString())
            dataList.clear()

            rvTransfer.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
            rvTransfer.adapter = SearchReceiverAdapter(dataList,this)
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun onClick(v: View, data: Data) {
        Toast.makeText(activity,"hello ${data.fullName}",Toast.LENGTH_SHORT).show()
        bundle = bundleOf("data" to data)

        view?.let { Navigation.findNavController(it).navigate(R.id.action_input_saldo, bundle) }
    }

}