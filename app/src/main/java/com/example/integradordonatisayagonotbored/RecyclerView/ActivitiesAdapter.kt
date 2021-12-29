package com.example.integradordonatisayagonotbored.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.integradordonatisayagonotbored.R

class ActivitiesAdapter(private var activitiesCategoriesList : List<String>) : RecyclerView.Adapter<ActivitiesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ActivitiesViewHolder(layoutInflater.inflate(R.layout.cell_category, parent, false))
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val categoryAtPosition = activitiesCategoriesList[position]
        holder.bindCategory(categoryAtPosition)
    }

    override fun getItemCount() = activitiesCategoriesList.size
}