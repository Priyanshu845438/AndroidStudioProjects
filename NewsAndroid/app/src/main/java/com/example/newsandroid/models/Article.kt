package com.example.newsandroid.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.io.Serializable

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    @Embedded
    val source: NewsSource?,  // Renamed from Source to NewsSource
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable

data class NewsSource(  // Renamed from Source to NewsSource
    @ColumnInfo(name = "source_id") // Avoid column name conflict
    val id: String?,
    val name: String?
)
