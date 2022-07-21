package com.mc.qr.api

data class loginResponse(
    var token:String,
    var nombre:String,
    var user:List<String>
    )