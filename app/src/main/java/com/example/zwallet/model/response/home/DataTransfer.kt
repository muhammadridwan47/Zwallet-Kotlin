package com.example.zwallet.model.response.home

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataTransfer(
    @Expose
    @SerializedName("amountTransfer")
    val amountTransfer: Int,
    @Expose
    @SerializedName("dateTransfer")
    val dateTransfer: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("img")
    val img: String,
    @Expose
    @SerializedName("note")
    val note: String,
    @Expose
    @SerializedName("receiveBy")
    val receiveBy: String,
    @Expose
    @SerializedName("receiver")
    val receiver: Int,
    @Expose
    @SerializedName("sendBy")
    val sendBy: Int,
    @Expose
    @SerializedName("sender")
    val sender: String,
    @Expose
    @SerializedName("status")
    val status: String
) : Parcelable