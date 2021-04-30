package com.example.zwallet.model.response.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @Expose
    @SerializedName("balance")
    val balance: Int,
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
    @SerializedName("phoneNumber")
    val phoneNumber: Int,
    @Expose
    @SerializedName("pin")
    val pin: String
)