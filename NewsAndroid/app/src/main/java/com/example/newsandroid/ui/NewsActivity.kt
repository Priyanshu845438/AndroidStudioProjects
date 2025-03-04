package com.example.newsandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newsandroid.databinding.ActivityMainBinding
import com.example.newsandroid.db.ArticleDatabase
import com.example.newsandroid.repository.NewsRepository
import com.example.newsandroid.viewmodel.NewsViewModel
import com.example.newsandroid.viewmodel.NewsViewModelProviderFactory

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ✅ Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Initialize Database & ViewModel
        val database = ArticleDatabase.getInstance(this)
        val newsRepository = NewsRepository(database)
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        newsViewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
    }
}
