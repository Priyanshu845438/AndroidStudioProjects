package com.example.newsandroid.db

import androidx.room.TypeConverter
import com.example.newsandroid.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name ?: ""
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(null, name)
    }
}
