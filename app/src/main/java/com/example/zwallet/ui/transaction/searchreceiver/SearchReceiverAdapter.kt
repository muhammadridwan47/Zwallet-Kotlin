package com.example.zwallet.ui.transaction.searchreceiver

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zwallet.R
import com.example.zwallet.model.response.transaction.searchreceiver.Data

class SearchReceiverAdapter(
    private var data:  List<Data>,
    private val itemAdapterCallback : ItemAdapterCallback
    ) : RecyclerView.Adapter<SearchReceiverAdapter.SearchReceiverAdapterHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchReceiverAdapterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context

        val inflatedView : View = layoutInflater.inflate(R.layout.list_item_vertical_noprice, parent, false)
        return SearchReceiverAdapterHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SearchReceiverAdapterHolder, position: Int) {
        holder.bindItem(data[position],itemAdapterCallback ,ContextAdapter, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class SearchReceiverAdapterHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
         private val imageList: ImageView = itemView.findViewById(R.id.imgList)
         private val nameList: TextView = itemView.findViewById(R.id.nameList)
         private val numberphone: TextView = itemView.findViewById(R.id.numberPhone)


        fun bindItem(data: Data,itemAdapterCallback: ItemAdapterCallback,context: Context,position: Int) {



            nameList.text = data.fullName
            numberphone.text = data.phoneNumber.toString()
            val img = "http://192.168.1.8:7000/images/${data.img}"
            Glide.with(context)
                .load(img)
                .into(imageList)

            itemView.setOnClickListener {
                Log.v("tamvan click ",it.toString())
                itemAdapterCallback.onClick(it, data)
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: Data)
    }
}