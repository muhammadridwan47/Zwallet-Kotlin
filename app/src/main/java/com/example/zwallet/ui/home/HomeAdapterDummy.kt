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
import kotlinx.android.synthetic.main.list_item_vertical.view.*

class HomeAdapterDummy(
    private var data:  List<HomeModel>,
    private val listener: (HomeModel) -> Unit
    ) : RecyclerView.Adapter<HomeAdapterDummy.HomeAdapterHolder>() {

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

        fun bindItem(data: HomeModel, listener: (HomeModel) -> Unit,context: Context,position: Int) {

            nameList.text = data.name
            typeList.text = data.type
            priceList.text = "+" + data.price.toString()

            Glide.with(context)
                .load(data.image)
                .into(imageList)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }
}