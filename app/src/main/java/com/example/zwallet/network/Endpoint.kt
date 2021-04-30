package com.example.zwallet.network

import com.example.zwallet.model.response.home.HomeResponse
import com.example.zwallet.model.response.login.LoginResponse
import com.example.zwallet.model.response.login.Token
import com.example.zwallet.model.response.transaction.pinconfirmation.Data
import com.example.zwallet.model.response.transaction.pinconfirmation.PinResponse
import com.example.zwallet.model.response.transaction.searchreceiver.SearchReceiverResponse
import io.reactivex.Observable
import retrofit2.http.*

interface Endpoint {

    @FormUrlEncoded
    @POST("auth/login")
    fun login(@Field("email") email: String,
              @Field("password") password: String): Observable<LoginResponse<Token>>

    @GET("user/home")
    fun home(): Observable<HomeResponse>

    @GET("user/all")
    fun getUsers(@Query("search") search: String): Observable<SearchReceiverResponse>

    @FormUrlEncoded
    @POST("transaction")
    fun transaction(
            @Field("receiver") receiver: Int,
            @Field("status") status: String,
            @Field("note") note: String,
            @Field("amountTransfer") amountTransfer: Int,
            @Field("balanceLeft") balanceLeft: Int,
            @Field("pin") pin: Int
    ): Observable<PinResponse<Data>>
}