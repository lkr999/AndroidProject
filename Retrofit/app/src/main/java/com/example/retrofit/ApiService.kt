package com.example.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @GET("exam/insert2.php?id=1111 & firstname=1111 & lastname=1111 & email=1111@gmail.com & password=1111 & gender=1111")
    fun getPost(): Call<List<PostModel>>

    @POST("exam/insert2.php")
    fun postRequest(@Body body: Map<String, String>): Call<PostModel>
}

