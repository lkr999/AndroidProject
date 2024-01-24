//package com.example.wh_transfer
//
//import retrofit2.Call
//import retrofit2.Response
//import retrofit2.http.Field
//import retrofit2.http.FormUrlEncoded
//import retrofit2.http.GET
//import retrofit2.http.Multipart
//import retrofit2.http.POST
//import retrofit2.http.PartMap
//
//interface ApiService {
//    @GET("exam/insert2.php")
//    fun getPost(): Call<List<PostModel>>
//
//    @FormUrlEncoded
//    @POST("exam/insert2.php")
//    suspend fun pushPost(
//       @Field("id") id: String,
//       @Field("firstname") firstname: String,
//       @Field("lastname") lastname: String,
//       @Field("email") email: String,
//       @Field("gender") gender: String,
//       @Field("password") password: String
//    ): Response<Posts>
//
//}