package com.example.integradordonatisayagonotbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.integradordonatisayagonotbored.RecyclerView.ActivitiesAdapter
import com.example.integradordonatisayagonotbored.databinding.ActivitySuggestionActivitiesBinding
import org.w3c.dom.Text

class SuggestionActivitiesActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySuggestionActivitiesBinding
    private lateinit var adapter: ActivitiesAdapter
    private lateinit var participantAmount : Text

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //intent.extras?.run { participantAmount = getString() }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val categories = Categories()
        adapter = ActivitiesAdapter(categories.categoriesList)
        binding.RVSuggestionActivity.adapter = adapter
    }
}