package com.hendra.smagawi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        splash()
    }
    fun splash(){
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java).also { finish() })
        }, 3000)
    }
}