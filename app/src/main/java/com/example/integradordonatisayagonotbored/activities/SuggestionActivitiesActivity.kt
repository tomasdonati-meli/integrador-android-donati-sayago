package com.example.integradordonatisayagonotbored.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.integradordonatisayagonotbored.Categories
import com.example.integradordonatisayagonotbored.NotBoredApplication.Companion.prefs
import com.example.integradordonatisayagonotbored.recyclerView.ActivitiesAdapter
import com.example.integradordonatisayagonotbored.databinding.ActivitySuggestionActivitiesBinding
import com.example.integradordonatisayagonotbored.recyclerView.OnItemClickListener
import com.example.integradordonatisayagonotbored.retrofit.ApiBoredService
import com.example.integradordonatisayagonotbored.retrofit.BoredResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuggestionActivitiesActivity : AppCompatActivity(), OnItemClickListener{
    private lateinit var binding : ActivitySuggestionActivitiesBinding
    private lateinit var adapter: ActivitiesAdapter
    private val categories = Categories()//created an instance of our class holding the category list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView() //set up method for our recycler view
        setOnClicks()
    }

    //TODO for now, it only returns education activities
    private fun setOnClicks(){
        binding.ButtonSuggestionActivityRandomSearch.setOnClickListener {
            val intentSelectedSuggestionAct = Intent(this, SelectedSuggestionActivity::class.java)
            startActivity(intentSelectedSuggestionAct)
        }
    }

    private fun setupRecyclerView() {
        adapter = ActivitiesAdapter(categories.categoriesList,this)
        binding.RVSuggestionActivity.adapter = adapter
    }

    //method used by the listener to manage click events on RecyclerView items
    override fun onItemClick(position: Int) {
        val selectedElement = categories.categoriesList[position]
        prefs.saveCategoryName(selectedElement)
        val intentSelectedSuggestionAct = Intent(this, SelectedSuggestionActivity::class.java)
        startActivity(intentSelectedSuggestionAct)
    }
}