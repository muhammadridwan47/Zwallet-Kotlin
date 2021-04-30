package com.example.zwallet.model.response.transaction.pinconfirmation

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    @Expose
    @SerializedName("amountTransfer")
    val amountTransfer: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("note")
    val note: String,
    @Expose
    @SerializedName("receiver")
    val receiver : String,
    @Expose
    @SerializedName("sendBy")
    val sendBy: Int,
    @Expose
    @SerializedName("status")
    val status: String
): Parcelable
