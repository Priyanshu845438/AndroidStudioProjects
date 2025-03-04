package com.example.toastapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val cityEditText = findViewById<EditText>(R.id.editTextCity)
        val showButton = findViewById<Button>(R.id.buttonShow)

        showButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val city = cityEditText.text.toString()
            if (name.isEmpty() || city.isEmpty()) {
                Toast.makeText(this, "Please enter Name and City", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Name: $name\nCity: $city", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
