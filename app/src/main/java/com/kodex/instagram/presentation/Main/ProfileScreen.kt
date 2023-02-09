package com.kodex.instagram.presentation.Main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.navigation.NavController
import com.kodex.instagram.presentation.Profile.BottomNavigationItem
import com.kodex.instagram.presentation.Profile.BottomNavigationMenu
import com.kodex.instagram.util.TopBar

@Composable
fun ProfileScreen(navController: NavController){
    Scaffold(
        topBar = { TopBar() },
        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Profile Screen")
                }
                BottomNavigationMenu(selectedItem = BottomNavigationItem.PROFILE,
                    navController = navController)
                  }
             }
        )

    }


