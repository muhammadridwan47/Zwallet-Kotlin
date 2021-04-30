package com.example.zwallet.model.response.topup

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
class TopUpResponse (
    var id: Int ?= 0,
    var information: String ?= ""
) :  Parcelable
