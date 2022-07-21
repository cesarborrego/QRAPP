package com.mc.qr.service

import com.mc.qr.api.loginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    @GET
    fun getLogin(@Url url:String):Response<loginResponse>
}