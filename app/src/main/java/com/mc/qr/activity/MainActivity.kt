package com.mc.qr.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mc.qr.databinding.ActivityMainBinding
import com.mc.qr.service.APIservice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    private fun login(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call= getRetrofit().create(APIservice::class.java).getLogin("api/login")
            val usuariologin= call.body()
            runOnUiThread{
                if(call.isSuccessful){
                    //show Recyclerview
                }else{
                   showError()
                }
            }

        }
    }

    private fun showError() {
     Toast.makeText(this, "Hay un problema de conexión",Toast.LENGTH_SHORT).show()
    }

}