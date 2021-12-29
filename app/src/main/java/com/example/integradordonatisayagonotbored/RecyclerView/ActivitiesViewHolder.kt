package com.example.integradordonatisayagonotbored.RecyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.integradordonatisayagonotbored.databinding.CellCategoryBinding

class ActivitiesViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val binding = CellCategoryBinding.bind(view)

    fun bindCategory(categoryAtPosition: String) {
        binding.TextViewCellCategory.text = categoryAtPosition // TODO VEEEEERRRRRRR
    }
}