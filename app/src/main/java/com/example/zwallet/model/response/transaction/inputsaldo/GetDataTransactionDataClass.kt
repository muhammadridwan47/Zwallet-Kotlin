package com.example.zwallet.model.response.transaction.inputsaldo
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetDataTransactionDataClass (
        @Expose
        @SerializedName("id")
        val id: Int?,
        @Expose
        @SerializedName("balance")
        val balance: Int?,
        @Expose
        @SerializedName("fullName")
        val fullName: String?,
        @Expose
        @SerializedName("img")
        val img: String?,
        @Expose
        @SerializedName("phoneNumber")
        val phoneNumber: Int?,
        @Expose
        @SerializedName("amount")
        val amount: Int?,
        @Expose
        @SerializedName("balanceLeft")
        val balanceLeft: Int?,
        @Expose
        @SerializedName("note")
        val note: String?

 ): Parcelable
