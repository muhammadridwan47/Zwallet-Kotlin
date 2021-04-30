package com.example.zwallet.model.response.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Token(
    @Expose
    @SerializedName("fcm")
    val fcm: String,
    @Expose
    @SerializedName("role")
    val role: Int,
    @Expose
    @SerializedName("token")
    val token: String
)