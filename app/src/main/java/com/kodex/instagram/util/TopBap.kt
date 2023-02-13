package com.kodex.instagram.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.kodex.instagram.presentation.Authentication.AuthenticationViewModel
import com.kodex.instagram.R



@Composable
fun TopBar() {
    val navController = rememberNavController()
    val viewModel: AuthenticationViewModel = hiltViewModel()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                ImageVector.vectorResource(id = R.drawable.title_topbar),
                contentDescription = ""
            )
        }
        Icon(
            ImageBitmap.imageResource(id = R.drawable.ic_dm),
            modifier = Modifier.icon(),
            contentDescription = ""
        )
        // if (response.data){
        Icon(imageVector = Icons.Default.ExitToApp,
            contentDescription = "",
            modifier = Modifier.clickable {
                viewModel.signOut {
                    navController.navigate(Screens.LoginScreen.route){
                        popUpTo(Screens.SearchScreen.route){
                            inclusive = true
                        }
                    }
                }
            }
        )
        // }
    }
}