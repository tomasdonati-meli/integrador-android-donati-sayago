package com.example.integradordonatisayagonotbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.integradordonatisayagonotbored.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.EditTextMainActivityParticipantAmount.addTextChangedListener()
        binding.ButtonMainActivityStart.setOnClickListener {
            val intentSuggestionAct = Intent(this,SuggestionActivitiesActivity::class.java)
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
