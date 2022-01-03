package com.example.integradordonatisayagonotbored.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.integradordonatisayagonotbored.R
import com.example.integradordonatisayagonotbored.databinding.ActivitySelectedSuggestionBinding
import com.example.integradordonatisayagonotbored.retrofit.ApiBoredService
import com.example.integradordonatisayagonotbored.retrofit.BoredResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SelectedSuggestionActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySelectedSuggestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedSuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)






    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/activity/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun apiCall(participantAmount: String){
        CoroutineScope(Dispatchers.IO).launch {

            val call = getRetrofit()
                .create(ApiBoredService::class.java)
                .getRandomActivityByParticipants("?participants=$participantAmount")

            val boredResponse : BoredResponse? = call.body()

            runOnUiThread {
                if(call.isSuccessful){
                }
            }
        }
    }
}