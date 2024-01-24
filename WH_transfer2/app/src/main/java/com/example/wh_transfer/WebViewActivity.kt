package com.example.wh_transfer

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import com.example.wh_transfer.R.id.*
import org.w3c.dom.Text

class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view2)

        val url: String = intent.getStringExtra("url").toString()
        val webView2 = findViewById<WebView>(web_2)
        val webSettings: WebSettings = webView2.settings

        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webView2.webViewClient = WebViewClient()
        webView2.loadUrl(url)
    }

    val webViewClient: WebViewClient = object : WebViewClient() {

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            Log.d("TAG_WebView", "shouldOverrideUrlLoading")
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
            Log.d("TAG_WebView","onReceivedError")
            view?.loadUrl("about:blank")
            view?.clearHistory()
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
//            urlTitle.text = url
            Log.d("TAG_WebView","onPageStarted")
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            Log.d("TAG_WebView","onPageFinished")
        }

    }


}