package com.example.integradordonatisayagonotbored.retrofit

import com.google.gson.annotations.SerializedName
//data class in charge of modelling the results
data class BoredResponse(@SerializedName("type") var categoryName: String,
                         @SerializedName("activity")var activityDescription: String,
                         @SerializedName("price") var price: String) {

}