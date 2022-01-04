package com.example.integradordonatisayagonotbored

import android.content.Context

class Prefs(context: Context) {

    private val sharedName = "MyDatabase"
    val SHARED_PARTICIPANT_AMOUNT = "participantAmount"
    val SHARED_CATEGORY_NAME = "categoryName"

    val storage = context.getSharedPreferences(sharedName, 0)

    fun saveParticipantAmount(amount: Int){
        storage.edit().putInt(SHARED_PARTICIPANT_AMOUNT, amount).apply()
    }

    fun saveCategoryName(category: String){
        storage.edit().putString(SHARED_CATEGORY_NAME, category).apply()
    }

    fun getParticipantAmount():Int{
        return storage.getInt(SHARED_PARTICIPANT_AMOUNT, 0)
    }

    fun getCategoryName():String{
        return storage.getString(SHARED_CATEGORY_NAME, "")!!
    }
}