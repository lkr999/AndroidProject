//package com.example.wh_transfer
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitClient {
//    private const val BASE_URL = "https://10.50.3.163:3306/" // 서버도메인URL
//    private var retrofit: Retrofit? = null
//    open val client: Retrofit?
//        get() {
//            if (retrofit == null) {
//                retrofit = Retrofit.Builder()
//                    .baseUrl(BASE_URL) // 접속할 서버를 설정
//                    .addConverterFactory(GsonConverterFactory.create()) // json response를 파싱하기 위해 Gson을 설정
//                    .build()
//            }
//            return retrofit
//        }
//}