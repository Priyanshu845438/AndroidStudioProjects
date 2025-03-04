package com.example.intentdataapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputData = findViewById<EditText>(R.id.editTextData)
        val sendButton = findViewById<Button>(R.id.buttonSend)

        sendButton.setOnClickListener {
            val message = inputData.text.toString()

            if (message.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("MESSAGE", message)
                startActivity(intent)
            } else {
                inputData.error = "Please enter some text"
            }
        }
    }
}
