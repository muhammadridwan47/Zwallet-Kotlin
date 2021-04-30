package com.example.zwallet.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.zwallet.R
import com.example.zwallet.Zwallet
import com.example.zwallet.ui.MainActivity
import com.example.zwallet.ui.auth.AuthActivity

class SplashScrenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_scren)

        Handler().postDelayed({
            if (!Zwallet.getApp().getToken().isNullOrEmpty()) {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this,AuthActivity::class.java))
                finish()
            }
        },2000)


    }

}