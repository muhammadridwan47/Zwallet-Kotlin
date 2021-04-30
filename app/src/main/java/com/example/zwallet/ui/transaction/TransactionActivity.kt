package com.example.zwallet.ui.transaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zwallet.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class TransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)


        toolbar.title = "Find Receiver"
        toolbar.setNavigationOnClickListener {onBackPressed()}
    }
}