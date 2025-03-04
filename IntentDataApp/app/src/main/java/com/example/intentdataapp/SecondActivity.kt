package com.example.intentdataapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val receivedText = findViewById<TextView>(R.id.textViewDisplay)
        val message = intent.getStringExtra("MESSAGE")

        receivedText.text = message ?: "No data received"
    }
}
