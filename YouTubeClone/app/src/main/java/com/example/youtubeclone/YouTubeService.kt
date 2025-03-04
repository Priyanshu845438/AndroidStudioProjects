package com.example.youtubeclone

import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.youtube.YouTube
import com.google.api.services.youtube.model.SearchListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object YouTubeService {
    private const val API_KEY = "AIzaSyDhO9D2kEdTeNqCsLZ70I6EPKGE-AkUaTA"
    private const val APPLICATION_NAME = "YouTubeClone"

    private val jsonFactory: JsonFactory = GsonFactory.getDefaultInstance()

    private val youtube: YouTube = YouTube.Builder(
        NetHttpTransport(),
        jsonFactory,
        HttpRequestInitializer { }
    ).setApplicationName(APPLICATION_NAME).build()

    suspend fun getTrendingVideos(): List<VideoData> {
        return withContext(Dispatchers.IO) {
            val search = youtube.search().list("snippet")
            search.key = API_KEY
            search.q = "Trending"
            search.maxResults = 10
            search.type = "video"

            val response: SearchListResponse = search.execute()
            response.items.map { item ->
                VideoData(
                    videoId = item.id.videoId ?: "",
                    title = item.snippet.title,
                    description = item.snippet.description,
                    thumbnailUrl = item.snippet.thumbnails.default.url
                )
            }
        }
    }
}
