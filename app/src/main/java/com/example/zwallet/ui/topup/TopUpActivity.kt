package com.example.zwallet.ui.topup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zwallet.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class TopUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_up)

        toolbar.title = "Top Up"
        toolbar.setNavigationOnClickListener {onBackPressed()}
    }
}