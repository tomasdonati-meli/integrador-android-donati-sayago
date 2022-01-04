package com.example.integradordonatisayagonotbored.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.integradordonatisayagonotbored.NotBoredApplication.Companion.prefs
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

        //getting shared preferences for the service to make the GET request, and to feed the UI
        val participantAmount = prefs.getParticipantAmount()
        val categoryName = prefs.getCategoryName()

        apiCallByCategory(categoryName, participantAmount)
        setOnClicks(categoryName, participantAmount)

    }

    private fun setOnClicks(categoryName: String, participantAmount: Int){
        binding.ImageButtonSelectedSuggestionTryAnother.setOnClickListener {
            apiCallByCategory(categoryName, participantAmount)
        }
    }

    //method used to set up retrofit instance
    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //coroutine calling getActivityByCategoryAndParticipants() method from Service
    private fun apiCallByCategory(categoryName : String, participantAmount : Int){
        CoroutineScope(Dispatchers.IO).launch {

            val call = getRetrofit()
                .create(ApiBoredService::class.java)
                .getActivityByCategoryAndParticipants(categoryName, participantAmount)

            val boredResponse : BoredResponse? = call.body()

            //setting up the UI on a UI thread
            runOnUiThread {
                if(call.isSuccessful){
                    binding.TextViewSelectedSuggestionTitle.text = categoryName
                    binding.TextViewSelectedSuggestionDescription.text = boredResponse?.activityDescription
                    binding.TextViewSelectedSuggestionParticipantAmount.text = participantAmount.toString()
                    binding.TextViewSelectedSuggestionPriceValue.text = boredResponse?.price
                    binding.TextViewSelectedSuggestionRandomCategoryName.text = categoryName
                }
            }
        }
    }

    private fun modifyPriceView(){}
}