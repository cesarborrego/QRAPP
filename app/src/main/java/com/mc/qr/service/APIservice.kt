package com.mc.qr.service

import com.mc.qr.api.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface APIservice {
    @GET
    suspend fun getLogin(@Url url:String):Call<UserResponse>

    @GET("/api/login")
    fun getUsers(
        @Query("user") user:String,
        @Query("password") password:String
        ):Call<UserResponse>
}