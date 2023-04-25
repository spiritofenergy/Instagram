package com.example.instagramclone.presentation.Main.Posts

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/*@Composable
fun Stories() {
    val posts = remember { DataDummy.storyList }
    LazyRow(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
        items(posts) {
            StoryListItem(post = it)
        }
    }
}

@Composable
fun StoryListItem(post: Story) {
    val imageModifier =
        if (post.id == 1) {
            Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                .height(60.dp)
                .width(60.dp)
                .clip(CircleShape)
                .border(
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 3.dp,
                        color = Color.LightGray
                    )
                )
        } else {
            Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                .height(60.dp)
                .width(60.dp)
                .clip(CircleShape)
                .border(
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 3.dp,
                        brush = Brush.linearGradient(
                            colors = instagramGradient,
                            start = Offset(
                                0f,
                                0f
                            ),
                            end = Offset(
                                100f,
                                100f
                            )
                        )
                    )
                )
        }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = post.authorImageId),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = imageModifier
        )
        Text(text = post.author, style = typography.caption, textAlign = TextAlign.Center)
    }
}

 */