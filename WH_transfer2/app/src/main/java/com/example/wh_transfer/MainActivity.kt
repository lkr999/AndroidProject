package com.example.wh_transfer

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.wh_transfer.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONStringer
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset
import java.security.Provider.Service

class MainActivity : AppCompatActivity() {
    private var requestQueue: RequestQueue?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(applicationContext)
    }

    fun get_data(view: View) {
        var url = "http://10.50.3.163/exam/insert2.php"
        var sendData = JSONObject()
        sendData.put("id", "1111")
        sendData.put("firstname", "KR")
        sendData.put("lastname", "lee3")
        sendData.put("email", "qqerq@gmail.com")
        sendData.put("gender", "female")
        sendData.put("password", "2313")

        val request = JsonObjectRequest(
            Request.Method.GET,
            url,
            sendData,
            { response ->
            }, {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                var body = String(it.networkResponse.data, Charsets.UTF_8)
            }
        )
        requestQueue?.add(request)
    }


    fun post_data(view: View) {
    }

    fun qr_scan(view: View) {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Start Scan the QR Code")
        integrator.setCameraId(0)
        integrator.setBeepEnabled(true)
        integrator.setBarcodeImageEnabled(true)
        integrator.initiateScan()
        IntentIntegrator(this).initiateScan()
    }

    fun list_display (view: View) {

        val edt1: TextInputEditText = findViewById(R.id.edt_1)

        var edt_id:EditText = findViewById(R.id.edt_id)
        var edt_fristname:EditText = findViewById(R.id.edt_firstname)
        var edt_lastname:EditText = findViewById(R.id.edt_lastname)
        var edt_email:EditText = findViewById(R.id.edt_email)
        var edt_gender:EditText = findViewById(R.id.edt_gender)

        //Web Page Intent ---
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url",edt1.text.toString())
        startActivity(intent)
    }


    @SuppressLint("WrongViewCast")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        var result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        var txt2 = findViewById<TextView>(R.id.txt_scanResult)

        if (result != null) {
          if (result.contents != null) {
//              Toast.makeText(this, "contents: ${result.contents}", Toast.LENGTH_LONG).show()
              txt2.text = result.contents.toString()
          } else {
              Toast.makeText(this, "Cancled", Toast.LENGTH_LONG).show()
          }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }

}

