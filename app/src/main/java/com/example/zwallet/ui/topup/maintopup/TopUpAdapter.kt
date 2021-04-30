package com.example.zwallet.ui.topup.maintopup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zwallet.R
import com.example.zwallet.model.response.topup.TopUpResponse

class TopUpAdapter(
    private var data:  List<TopUpResponse>,
    private val listener: (TopUpResponse) -> Unit
) : RecyclerView.Adapter<TopUpAdapter.TopUpAdapterHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopUpAdapterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context

        val inflatedView : View = layoutInflater.inflate(R.layout.list_item_topup, parent, false)
        return TopUpAdapterHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: TopUpAdapterHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class TopUpAdapterHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val id: TextView = view.findViewById(R.id.number_topup)
        private val information: TextView = view.findViewById(R.id.information_topup)

        fun bindItem(data: TopUpResponse, listener: (TopUpResponse) -> Unit, context: Context, position: Int) {

            id.text = data.id.toString()
            information.text = data.information

        }
    }
}







//package com.example.zwallet.ui.home
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.zwallet.R
//import kotlinx.android.synthetic.main.list_item_vertical.view.*
//
//class HomeAdapterDummy(
//    private var data:  List<HomeModel>,
//    private val listener: (HomeModel) -> Unit
//) : RecyclerView.Adapter<HomeAdapterDummy.HomeAdapterHolder>() {
//
//
//}