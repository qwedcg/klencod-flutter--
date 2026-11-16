
package com.dafan.aiagent

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.JavascriptInterface
import android.content.Intent
import android.net.Uri

class MainActivity : Activity() {

    private lateinit var web: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        web = WebView(this)

        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true

        web.webViewClient = WebViewClient()

        web.addJavascriptInterface(
            Bridge(),
            "Dafan"
        )

        setContentView(web)

        web.loadUrl("file:///android_asset/index.html")
    }

    inner class Bridge {

        @JavascriptInterface
        fun openUrl(url: String) {
            runOnUiThread {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )
                startActivity(intent)
            }
        }

        @JavascriptInterface
        fun deviceInfo(): String {
            return "Android ${android.os.Build.VERSION.RELEASE} | ${android.os.Build.MODEL}"
        }
    }

    override fun onDestroy() {
        web.destroy()
        super.onDestroy()
    }
}
