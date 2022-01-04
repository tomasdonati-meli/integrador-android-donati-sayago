package com.example.integradordonatisayagonotbored.retrofit

import androidx.annotation.Keep
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiBoredService {

    @GET("activity/")
    suspend fun getRandomActivityByParticipants(@Query ("participants") participants : Int) : Response<BoredResponse>

    @GET("activity/")
    suspend fun getActivityByCategoryAndParticipants(@Query("type") category: String,
                                                     @Query("participants") participants: Int) : Response<BoredResponse>

}