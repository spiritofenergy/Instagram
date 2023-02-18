package com.kodex.instagram.presentation.Authentication

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.kodex.instagram.domain.model.Post
import com.kodex.instagram.domain.model.PostViewModel
import com.kodex.instagram.domain.model.Story
import com.kodex.instagram.presentation.Main.Profile.Posts.InstagramHomeContent
import com.kodex.instagram.presentation.Profile.BottomNavigationItem
import com.kodex.instagram.presentation.Profile.BottomNavigationMenu
import com.kodex.instagram.presentation.Profile.Toast
import com.kodex.instagram.util.TopBar

@Composable
fun FeedsScreen(navController: NavHostController) {
    val postViewModel : PostViewModel = hiltViewModel()
    postViewModel.getAllPosts()

    when(val response = postViewModel.postData.value){
        com.kodex.instagram.util.Response.Loading -> {
                    CircularProgressIndicator()
        }

        is com.kodex.instagram.util.Response.Success -> {
            val obj = response.data
            Scaffold(
                topBar = {TopBar()},
                content = {
                    InstagramHomeContent()
                },
                bottomBar = {
                    BottomNavigationMenu(selectedItem = BottomNavigationItem.FEED,
                        navController = navController)
                }
            )
        }
        is com.kodex.instagram.util.Response.Error -> {
            Toast(message = response.message)
    }
    }

}







