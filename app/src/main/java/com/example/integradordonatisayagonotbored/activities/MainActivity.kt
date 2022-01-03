package com.example.integradordonatisayagonotbored.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.integradordonatisayagonotbored.R
import com.example.integradordonatisayagonotbored.fragments.TermsAndConditionsFragment
import com.example.integradordonatisayagonotbored.databinding.ActivityMainBinding

const val PARTICIPANT_AMOUNT = "participantAmount"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.EditTextMainActivityParticipantAmount.addTextChangedListener()
        binding.ButtonMainActivityStart.setOnClickListener {
            val intentSuggestionAct = Intent(this, SuggestionActivitiesActivity::class.java).apply {
                putExtra(PARTICIPANT_AMOUNT, binding.EditTextMainActivityParticipantAmount.text)
            }
            startActivity(intentSuggestionAct)

        }

        //fragment setup
        binding.TextViewMainActivityTermsAndConditions.setOnClickListener {
            if(savedInstanceState == null){
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack(null)
                    add<TermsAndConditionsFragment>(R.id.FragmentContainerMainActivity)
                    }
                }
            }
        }

    }
