//package com.example.wh_transfer
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.EditText
//import android.widget.ProgressBar
//import android.widget.TextView
//import android.widget.Toast
//import com.android.volley.Request
//import com.android.volley.RequestQueue
//import com.android.volley.Response
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
//import com.example.wh_transfer.databinding.ActivityMainBinding
//import com.google.android.material.textfield.TextInputEditText
//import com.google.zxing.integration.android.IntentIntegrator
//import okio.Utf8
//import org.json.JSONException
//import org.json.JSONObject
//import org.json.JSONStringer
//import java.io.UnsupportedEncodingException
//import java.nio.charset.Charset
//
//class MainActivity_bak : AppCompatActivity() {
//    private var getRequest: StringRequest? = null
//    private var postRequest: StringRequest? = null
//    private var requestQueue: RequestQueue? = null
////    private val progressBar: ProgressBar = findViewById(R.id.progressBar)
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//        val api = APIS.create();
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////        startBarcodeCustomize(this)
//
//        requestQueue = Volley.newRequestQueue(this@MainActivity_bak)
//
//    }
//
//    fun post_data(view: View) {
//        postRequest()
//    }
//
//    fun get_data(view: View) {
//        getRequest()
//    }
//
//    @SuppressLint("SetTextI18n")
//    fun getRequest() {
//        var txt2 = findViewById<TextView>(R.id.txt_scanResult)
//
//        val progressBar:ProgressBar = findViewById(R.id.progressBar)
//        progressBar.visibility = View.VISIBLE
//        val url = "https://simplifiedcoding.net/demos/marvel"
//        getRequest = StringRequest(
//            Request.Method.GET, url,
//            { response ->
//                txt2.text = response
//                progressBar.visibility = View.GONE
//            }) {
//            txt2.text = "Something wrong"
//        }
//        getRequest!!.tag = "getRequest"
//        requestQueue!!.add(getRequest)
//    }
//
//    fun postRequest() {
//        var txt2 = findViewById<TextView>(R.id.txt_scanResult)
//        val progressBar: ProgressBar = findViewById(R.id.progressBar)
//        progressBar.visibility = View.VISIBLE
//        val url = "https://10.50.3.163/exam/insert.php"
//        var requestBody: String? = null
//        try {
//            val jsonBody = JSONObject()
//            jsonBody.put("firstname", "kwangryeol_1")
//            jsonBody.put("lastname", "lee")
//            jsonBody.put("id", "12")
//            jsonBody.put("email", "lee@gmail.com")
//            jsonBody.put("gendor", "")
//
//            postRequest = object : StringRequest(
//                Method.POST, url,
//                Response.Listener { response ->
//                    Log.d("Tag Response", response)
////                    txt2.text = response.toString()
//                    Toast.makeText(this, "CHK OK ---", Toast.LENGTH_LONG).show()
//
//                    progressBar.visibility = View.GONE
//                }, Response.ErrorListener { error ->
//                    Log.d("TAG_Error", error.toString())
//                    progressBar.visibility = View.GONE
//                }
//            ) {
//                override fun getBodyContentType(): String {
//                    return "application/json; charset=utf-8"
//                }
//
//                override fun getBody(): ByteArray? {
//                    return try {
//                        requestBody?.toByteArray(Charsets.UTF_8)
//                    } catch (e: UnsupportedEncodingException) {
//                        e.printStackTrace()
//                        null
//                    }
//                }
//            }
//            getRequest!!.tag = "postRequest"
//            requestQueue!!.add(postRequest)
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//    }
//
//    override fun onStop() {
//        val progressBar: ProgressBar = findViewById(R.id.progressBar)
//        super.onStop()
//        if (requestQueue !=null) {
//            requestQueue!!.cancelAll("getRequest")
//            requestQueue!!.cancelAll("postRequest")
//            progressBar.visibility = View.GONE
//        }
//    }
//
//    fun qr_scan(view: View) {
//        val integrator = IntentIntegrator(this)
//        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
//        integrator.setPrompt("Start Scan the QR Code")
//        integrator.setCameraId(0)
//        integrator.setBeepEnabled(true)
//        integrator.setBarcodeImageEnabled(true)
//        integrator.initiateScan()
//        IntentIntegrator(this).initiateScan()
//    }
//
//    fun list_display (view: View) {
//
//        val edt1: TextInputEditText = findViewById(R.id.edt_1)
//        val intent = Intent(this, WebViewActivity::class.java)
//
//        var edt_id:EditText = findViewById(R.id.edt_id)
//        var edt_fristname:EditText = findViewById(R.id.edt_firstname)
//        var edt_lastname:EditText = findViewById(R.id.edt_lastname)
//        var edt_email:EditText = findViewById(R.id.edt_email)
//        var edt_gender:EditText = findViewById(R.id.edt_gender)
//
//        var send_data = arrayListOf<String>(edt_id.toString(),edt_fristname.toString(),edt_lastname.toString(),edt_email.toString(),edt_gender.toString())
//
////        postData().execute(send_data)
//        intent.putExtra("url",edt1.text.toString())
//        startActivity(intent)
//    }
//
//    @SuppressLint("WrongViewCast")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//
//        var result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//        var txt2 = findViewById<TextView>(R.id.txt_scanResult)
//
//        if (result != null) {
//            if (result.contents != null) {
////              Toast.makeText(this, "contents: ${result.contents}", Toast.LENGTH_LONG).show()
//                txt2.text = result.contents.toString()
//            } else {
//                Toast.makeText(this, "Cancled", Toast.LENGTH_LONG).show()
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//
//    }
//
//
//
//}
