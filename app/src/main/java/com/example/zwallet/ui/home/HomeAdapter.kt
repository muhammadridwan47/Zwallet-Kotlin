package com.example.zwallet.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zwallet.R
import com.example.zwallet.model.response.home.DataTransfer

class HomeAdapter(
    private var data:  List<DataTransfer>,
    private val listener: (DataTransfer) -> Unit
    ) : RecyclerView.Adapter<HomeAdapter.HomeAdapterHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context

        val inflatedView : View = layoutInflater.inflate(R.layout.list_item_vertical, parent, false)
        return HomeAdapterHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: HomeAdapterHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class HomeAdapterHolder(view : View) : RecyclerView.ViewHolder(view) {
         private val imageList: ImageView = view.findViewById(R.id.imgList)
         private val nameList: TextView = view.findViewById(R.id.nameList)
         private val typeList: TextView = view.findViewById(R.id.typeList)
         private val priceList: TextView = view.findViewById(R.id.priceList)

        fun bindItem(data: DataTransfer, listener: (DataTransfer) -> Unit,context: Context,position: Int) {

            nameList.text = data.receiveBy
            typeList.text = data.status
            priceList.text = "+${data.amountTransfer}"
            val img = "http://192.168.1.8:7000/images/${data.img}"
            Glide.with(context)
                .load(img)
                .into(imageList)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }
}