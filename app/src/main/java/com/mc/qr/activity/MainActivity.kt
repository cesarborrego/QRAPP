package com.mc.qr.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mc.qr.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.15:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}