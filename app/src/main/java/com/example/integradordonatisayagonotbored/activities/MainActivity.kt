package com.example.integradordonatisayagonotbored.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.integradordonatisayagonotbored.NotBoredApplication.Companion.prefs
import com.example.integradordonatisayagonotbored.R
import com.example.integradordonatisayagonotbored.fragments.TermsAndConditionsFragment
import com.example.integradordonatisayagonotbored.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //UI set up
        uiSetup(savedInstanceState)

    }

    private fun uiSetup(savedInstanceState: Bundle?){
        //terms and conditions fragment setup
        binding.TextViewMainActivityTermsAndConditions.setOnClickListener {
            if(savedInstanceState == null){
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack(null)
                    add<TermsAndConditionsFragment>(R.id.FragmentContainerMainActivity)
                }
            }
        }
        //onClick intent and saving values to sharedPrefs
        setOnClicks()
        disableStartButton()
    }

    private fun setOnClicks(){
        binding.ButtonMainActivityStart.setOnClickListener {
            var participantAmount = binding.EditTextMainActivityParticipantAmount.text.toString()
            if(binding.EditTextMainActivityParticipantAmount.text.isNullOrEmpty()) participantAmount = "1" //handles empty inputs
            prefs.saveParticipantAmount(Integer.parseInt(participantAmount)) //saved the participant amount in our sharedPrefs
            val intentSuggestionAct = Intent(this, SuggestionActivitiesActivity::class.java)
            startActivity(intentSuggestionAct)

        }
    }

    private fun disableStartButton(){
        binding.EditTextMainActivityParticipantAmount.addTextChangedListener {
            binding.ButtonMainActivityStart.isEnabled =
                !(binding.EditTextMainActivityParticipantAmount.text.toString().contains("-")
                        || binding.EditTextMainActivityParticipantAmount.text.toString().contains(" ")
                        || binding.EditTextMainActivityParticipantAmount.text.toString().contains(".")
                        || binding.EditTextMainActivityParticipantAmount.text.toString().contains(","))
        }
    }

}
