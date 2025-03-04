package com.example.recyclerviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Dummy Data
        val itemList = listOf(
            ItemData("Item 1", "Description of Item 1"),
            ItemData("Item 2", "Description of Item 2"),
            ItemData("Item 3", "Description of Item 3"),
            ItemData("Item 4", "Description of Item 4"),
            ItemData("Item 5", "Description of Item 5")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(itemList)
    }
}
