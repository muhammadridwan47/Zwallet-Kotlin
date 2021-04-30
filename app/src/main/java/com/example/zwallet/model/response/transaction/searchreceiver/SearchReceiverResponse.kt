package com.example.zwallet.model.response.transaction.searchreceiver

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchReceiverResponse(
        @Expose
        @SerializedName("data")
    val data: List<Data>,
        @Expose
        @SerializedName("message")
    val message: String
)