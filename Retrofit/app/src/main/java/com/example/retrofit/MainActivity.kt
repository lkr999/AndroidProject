package com.example.retrofit

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var retrofit = RetrofitClient.client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun data_post(view: View) {
        var txt_1 = findViewById<TextView>(R.id.textView)

        val postApi = retrofit?.create(ApiService::class.java)

        postApi!!.getPost().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                if (response.isSuccessful) {
                    response.body()?.forEach {
//                        Log.d(TAG, "onResponse: ${it.userId}, ${it.title}")
                        txt_1.text = "Response OK"
                    }
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })

        val body = mapOf(
            "id" to "111",
            "firstname" to "adaadas",
            "lastname" to "dsaag",
            "email" to "value2@naver.com",
            "password" to "value2",
            "gender" to "value3"
        )

//        postApi!!.postRequest(body).enqueue(object : Callback<PostModel> {
//            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
//                txt_1.text = "Response OK" //response.toString()
//            }
//            override fun onFailure(call: Call<PostModel>, t: Throwable) {
//                txt_1.text = "Post Fail"
//            }
//        })

    }


}