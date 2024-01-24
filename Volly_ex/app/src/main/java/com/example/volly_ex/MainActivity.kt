package com.example.volly_ex

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volly_ex.R.layout.activity_main
import java.io.OutputStream
import java.net.URL
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

    }

    fun Volly_push(view: View) {
        var txt_1 = findViewById<TextView>(R.id.txt_status)
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
//        val url: String = "https://10.50.3.163/exam/insert3.php"
        val url: String = "https://10.50.3.163/volly/v1/index.html"
//        val url: String = "http://www.google.com/"
//        val url: String = "https://jsonplaceholder.typicode.com/posts"

        // Request a string response from the provided URL.
        val stringReq = StringRequest(
            Request.Method.GET, url,
            { response ->
                var strResp = response.toString()
                Log.d("API", strResp)
                txt_1.text = "Succeed"
                txt_1.text = response.toString()
            },
            {txt_1.text = "Fail"})
        queue.add(stringReq)
    }

    fun Volly_push_post(view: View) {
        var txt_1 = findViewById<TextView>(R.id.txt_status)
        val queue = Volley.newRequestQueue(this)
        val url = "https://10.50.3.163/exam/insert3.php"

        val requestBody = "id=123" + "&firstname=test_msg"+ "&lastname=test_msg"+ "&email=test_msg@gmail.com"+ "&password=test_msg"+ "&gender=test_msg"
        val stringReq : StringRequest =
            object : StringRequest(Method.POST, url,
                Response.Listener { response ->
                    // response
                    var strResp = response.toString()
                    txt_1.text = "Succeed"
                },
                Response.ErrorListener { error ->
                    Log.d("API", "error => $error")
                    txt_1.text = "Fail"
                }
            ){
                override fun getBody(): ByteArray {
                    return requestBody.toByteArray(Charset.defaultCharset())
                }
            }
        queue.add(stringReq)

    }

    fun task(view: View) {
        val url:URL = URL("https://10.50.3.163/exam/insert3.php")
        val postParameters = "firstname=kr&lastname=adadfadsf"
        val url_conn = url.openConnection()

    }
}


