package com.example.webviewtesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myWebView : WebView= findViewById(R.id.myURL)
        myWebView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,url : String?): Boolean {
              view?.loadUrl(url.toString())
                return true
            }
        }

        myWebView.loadUrl("https://testapp.accuprepare.com/login")
                myWebView.settings.javaScriptEnabled  = true
                myWebView.settings.allowContentAccess = true
                myWebView.settings.domStorageEnabled = true
                myWebView.settings.useWideViewPort = true

        CookieManager.getInstance().setCookie("https://testapp.accuprepare.com/login", "key=value");
        }
    private fun setCookie(){
        val webView = WebView(this) // this = context
        val cookieManager = CookieManager.getInstance()
        cookieManager.acceptCookie()

        val domain = "https://testapp.accuprepare.com/login"

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        cookieManager.setCookie(domain,"cookieKey = cookieValue")
        cookieManager.setAcceptThirdPartyCookies(webView, true)

        webView.loadUrl(domain)
    }
    }
