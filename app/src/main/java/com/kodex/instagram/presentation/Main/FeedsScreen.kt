package com.kodex.instagram.presentation.Authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.kodex.instagram.presentation.Profile.BottomNavigationItem
import com.kodex.instagram.presentation.Profile.BottomNavigationMenu
import com.kodex.instagram.util.TopBar

@Composable
fun FeedsScreen(navController: NavHostController) {
   Scaffold(
       topBar = {TopBar()},
       content = {
           Column(modifier = Modifier.fillMaxSize()) {
               Column(modifier = Modifier.weight(1f)) {
                   Text(text = "Feeds Screen")
               }
               BottomNavigationMenu(selectedItem = BottomNavigationItem.FEED,
                   navController = navController)
           }
       }
   )
}





