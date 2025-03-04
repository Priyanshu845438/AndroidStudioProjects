package com.example.firebaserealtimedbdemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.firebaserealtimedbdemo.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.editTextName)
        val emailInput = findViewById<EditText>(R.id.editTextEmail)
        val saveButton = findViewById<Button>(R.id.buttonSave)

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance().getReference("Users")

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                val userId = database.push().key ?: return@setOnClickListener
                val user = User(userId, name, email)

                database.child(userId).setValue(user).addOnSuccessListener {
                    Toast.makeText(this, "User Added Successfully!", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed to Add User!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter all details!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
