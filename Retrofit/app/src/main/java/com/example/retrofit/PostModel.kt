package com.example.retrofit

import com.google.gson.annotations.SerializedName

//class PostModel {
//    @SerializedName("userId")
//    var userId: Int = 0
//
//    @SerializedName("id")
//    var id: Int? = 0
//
//    @SerializedName("title")
//    var title: String? = null
//
//    @SerializedName("body")
//    var body: String? = null
//}

class PostModel {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("firstname")
    var firstname: String? = null

    @SerializedName("lastname")
    var lastname: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("password")
    var password: String? = null

    @SerializedName("gender")
    var gender: String? = null


}