package com.example.instagramclone.presentation.Main.Posts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instagramclone.R

/*
@Composable
fun InstagramHomeContent() {
    Column {
        InstagramStories()
        Divider()
        InstagramPostsList()
    }
}

@Composable
fun InstagramPostsList() {
    val posts = remember { DataDummy.storyList.filter { it.storyImageId != 0 } }
    LazyColumn {
        items(
            items = posts,
            itemContent = {
                InstagramListItem(post = it)
            }
        )
    }
}

 */