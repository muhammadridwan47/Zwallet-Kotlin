package com.example.zwallet.model.response.transaction.searchreceiver

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
        @Expose
        @SerializedName("balance")
    val balance: Int,
        @Expose
        @SerializedName("createdDate")
    val createdDate: String,
        @Expose
        @SerializedName("email")
    val email: String,
        @Expose
        @SerializedName("fullName")
    val fullName: String,
        @Expose
        @SerializedName("id")
    val id: Int,
        @Expose
        @SerializedName("img")
    val img: String,
        @Expose
        @SerializedName("isActive")
    val isActive: Int,
        @Expose
        @SerializedName("password")
    val password: String,
        @Expose
        @SerializedName("phoneNumber")
    val phoneNumber: Int,
        @Expose
        @SerializedName("pin")
    val pin: String
): Parcelable