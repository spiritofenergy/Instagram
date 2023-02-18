package com.kodex.instagram.presentation.Main.Profile.Posts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.kodex.instagram.domain.model.DataDummy


@Composable
    fun InstagramHomeContent() {
    Column {
        InstagramStories()
        Divider()
        InstagramPostList()
         }
    }

@Composable
fun InstagramPostList() {
    val posts = remember{ DataDummy.storyList.filter {it.storyImageId != 0}}

    LazyColumn{
        items(
            items = posts,
            itemContent = {
            InstagramListItem(post = it)
        })
    }


}
