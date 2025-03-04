package com.example.youtubeclone

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouTubeCloneApp { videoId ->
                val intent = Intent(this, YouTubePlayerScreen::class.java)
                intent.putExtra("VIDEO_ID", videoId)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun YouTubeCloneApp(onVideoClick: (String) -> Unit) {
    var videos by remember { mutableStateOf<List<VideoData>>(emptyList()) }

    LaunchedEffect(Unit) {
        videos = YouTubeService.getTrendingVideos()
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("YouTube Clone") }) },
        content = { paddingValues ->
            VideoFeedScreen(videos, onVideoClick) // Removed modifier
        }
    )
}

@Composable
fun VideoFeedScreen(videos: List<VideoData>, onVideoClick: (String) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(videos) { video ->
            VideoItem(video, onVideoClick)
        }
    }
}

@Composable
fun VideoItem(video: VideoData, onVideoClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onVideoClick(video.videoId) }
            .padding(8.dp)
    ) {
        Image(
            painter = rememberImagePainter(video.thumbnailUrl),
            contentDescription = video.title,
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(video.title, style = MaterialTheme.typography.h6)
        }
    }
}
