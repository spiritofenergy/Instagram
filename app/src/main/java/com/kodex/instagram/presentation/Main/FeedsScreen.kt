package com.kodex.instagram.presentation.Authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.kodex.instagram.presentation.Profile.BottomNavigationItem
import com.kodex.instagram.presentation.Profile.BottomNavigationMenu

@Composable
fun FeedsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Feeds Screen")
        }
        BottomNavigationMenu(selectedItem = BottomNavigationItem.FEED, navController = navController)

    }
}