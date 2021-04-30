package com.example.zwallet.ui.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class HomeModel(
    var id: Int ?= 0,
    var name: String ?= "",
    var type: String ?= "",
    var price: Int ?= 0,
    var image: Int ?= 0
) :  Parcelable