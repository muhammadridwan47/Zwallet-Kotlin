package com.example.zwallet.model.response.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @Expose
    @SerializedName("data")
    val data : List<DataTransfer>,
    @Expose
    @SerializedName("result")
    val result: List<Result>
)