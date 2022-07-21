package com.mc.qr.api

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("mensaje") var message:String,
    @SerializedName("id") var id:Int,
    @SerializedName("user") var user:User
    )

data class User(
    @SerializedName("password") var password:String,
    @SerializedName("username") var userName:String,
    @SerializedName("enable") var enable:Boolean
)