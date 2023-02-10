package com.kodex.instagram.presentation.Main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kodex.instagram.presentation.Profile.BottomNavigationItem
import com.kodex.instagram.presentation.Profile.BottomNavigationMenu
import com.kodex.instagram.presentation.Profile.Toast
import com.kodex.instagram.util.Response
import com.kodex.instagram.util.TopBar
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun ProfileScreen(navController: NavController){
    val userviewmodel : UserViewModel = hiltViewModel()
    userviewmodel.getUserInfo()
    when (val response = userviewmodel.getUserData.value){
        is Response.Loading -> {

        }
        is Response.Success -> {
            Log.d("successful", response.data.toString())
        }
        is Response.Error -> {
            Toast(message = response.message)
            Log.d("successful", "Ошибка загрузки")
        }
    }

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


