package com.example.integradordonatisayagonotbored.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.integradordonatisayagonotbored.R

class ActivitiesAdapter(private var activitiesCategoriesList : List<String>, private val listener : OnItemClickListener) : RecyclerView.Adapter<ActivitiesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ActivitiesViewHolder(layoutInflater.inflate(R.layout.cell_category, parent, false), listener)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val categoryAtPosition = activitiesCategoriesList[position]
        holder.bindCategory(categoryAtPosition)
    }

    override fun getItemCount() = activitiesCategoriesList.size

}
//this interface is used to deal with the OnClicks for the RecyclerView items
interface OnItemClickListener{
    fun onItemClick(position: Int)
}