package com.example.integradordonatisayagonotbored.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiBoredService {

    @GET
    suspend fun getRandomActivityByParticipants(@Url participants : String ) : Response<BoredResponse>

}