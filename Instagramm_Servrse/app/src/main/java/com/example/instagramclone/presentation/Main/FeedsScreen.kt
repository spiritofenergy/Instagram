package com.example.instagramclone.presentation.Main

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.instagramclone.R
import com.example.instagramclone.presentation.BottomNavigationItem
import com.example.instagramclone.presentation.BottomNavigationMenu
import com.example.instagramclone.presentation.Main.Posts.InstagramHomeContent
import com.example.instagramclone.presentation.Main.Posts.PostViewModel
import com.example.instagramclone.presentation.Toast
import com.example.instagramclone.util.Response

@Composable
fun FeedsScreen(navController: NavController) {
    val postsViewModel : PostViewModel = hiltViewModel()
    postsViewModel.getAllPosts()
    when (val response = postsViewModel.postData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }
        is Response.Success -> {
            val obj = response.data
            var selectedTabIndex by remember { mutableStateOf(0) }
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Instagram") },
                        backgroundColor = MaterialTheme.colors.surface,
                        contentColor = MaterialTheme.colors.onSurface,
                        elevation = 8.dp,
                        navigationIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_instagram),
                                    contentDescription = "logo",
                                    tint = Color.Unspecified
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_message),
                                    contentDescription = null,
                                    Modifier.size(30.dp),
                                    tint = Color.Black
                                )
                            }
                        }
                    )
                },
                content = {
                    InstagramHomeContent()
                },
                bottomBar = {
                    BottomNavigationMenu(selectedItem = BottomNavigationItem.FEED,
                        navController = navController)
                }
            )
        }
        is Response.Error ->{
            Toast(message = response.message)
        }
    }
}