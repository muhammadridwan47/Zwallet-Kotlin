package com.example.zwallet.model.response.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse<T>(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("success")
    val success: Boolean,
    @Expose
    @SerializedName("token")
    val token: Token
)