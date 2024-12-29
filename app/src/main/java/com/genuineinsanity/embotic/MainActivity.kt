package com.genuineinsanity.embotic

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient


class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webView)
        webView.setInitialScale(1)
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.scrollBarStyle = WebView.SCROLLBARS_INSIDE_OVERLAY
        webView.isScrollbarFadingEnabled = true
        // "Using setJavaScriptEnabled can introduce XSS vulnerabilities into your application" I have to enable it so
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowContentAccess = true
        webView.settings.allowFileAccess = true
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.settings.setSupportZoom(true)
        webView.isHorizontalScrollBarEnabled = false
        webView.isClickable = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
    }
        webView.loadUrl("https://dash.embotic.xyz")

    }
}