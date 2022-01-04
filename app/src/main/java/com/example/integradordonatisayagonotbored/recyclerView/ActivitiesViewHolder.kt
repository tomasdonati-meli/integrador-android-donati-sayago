package com.example.integradordonatisayagonotbored.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.integradordonatisayagonotbored.databinding.CellCategoryBinding

class ActivitiesViewHolder(view: View, private val listener : OnItemClickListener) : RecyclerView.ViewHolder(view), View.OnClickListener{
    private val binding = CellCategoryBinding.bind(view)

    fun bindCategory(categoryAtPosition: String) {
        binding.TextViewCellCategory.text = categoryAtPosition
    }

    //init works as the body for the constructor
    init {
        view.setOnClickListener(this)
    }

    //override of the interface method
    override fun onClick(p0: View?) {
        val position = adapterPosition
        if(position != RecyclerView.NO_POSITION){
            listener.onItemClick(adapterPosition)
        }
    }
}