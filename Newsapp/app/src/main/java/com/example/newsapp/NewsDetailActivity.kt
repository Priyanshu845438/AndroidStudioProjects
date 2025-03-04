package com.example.newsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageUrl = intent.getStringExtra("imageUrl")
        val articleUrl = intent.getStringExtra("url")

        val titleTextView: TextView = findViewById(R.id.newsDetailTitle)
        val descriptionTextView: TextView = findViewById(R.id.newsDetailDescription)
        val imageView: ImageView = findViewById(R.id.newsDetailImage)
        val readMoreButton: Button = findViewById(R.id.readMoreButton)

        titleTextView.text = title
        descriptionTextView.text = description
        imageView.load(imageUrl)

        readMoreButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(articleUrl))
            startActivity(intent)
        }
    }
}
