package com.example.instagramclone.presentation.Main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.instagramclone.presentation.BottomNavigationItem
import com.example.instagramclone.presentation.BottomNavigationMenu

@Composable
fun SearchScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier= Modifier.weight(1f)) {
            Text(text="Search Screen")
        }
        BottomNavigationMenu(selectedItem = BottomNavigationItem.SEARCH, navController = navController)
    }
}