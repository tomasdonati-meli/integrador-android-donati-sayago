package com.example.integradordonatisayagonotbored.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.integradordonatisayagonotbored.Categories
import com.example.integradordonatisayagonotbored.recyclerView.ActivitiesAdapter
import com.example.integradordonatisayagonotbored.databinding.ActivitySuggestionActivitiesBinding
import com.example.integradordonatisayagonotbored.recyclerView.OnItemClickListener

const val CATEGORY_NAME = "categoryName"
class SuggestionActivitiesActivity : AppCompatActivity(), OnItemClickListener{
    private lateinit var binding : ActivitySuggestionActivitiesBinding
    private lateinit var adapter: ActivitiesAdapter

    private val categories = Categories()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = ActivitiesAdapter(categories.categoriesList,this)
        binding.RVSuggestionActivity.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val selectedElement = categories.categoriesList[position]
        Toast.makeText(this, "$selectedElement clicked", Toast.LENGTH_SHORT).show()
        val intentSelectedSuggestionAct = Intent(this, SelectedSuggestionActivity::class.java).apply {
            putExtra(PARTICIPANT_AMOUNT, intent.getStringExtra(PARTICIPANT_AMOUNT))
            putExtra(CATEGORY_NAME, selectedElement)
        }

        startActivity(intentSelectedSuggestionAct)
    }
}