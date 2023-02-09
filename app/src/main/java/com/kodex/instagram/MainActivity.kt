package com.kodex.instagram

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kodex.instagram.presentation.Authentication.*
import com.kodex.instagram.ui.theme.InstagramTheme
import com.kodex.instagram.util.Screens
import com.kodex.instagram.presentation.Main.ProfileScreen
import com.kodex.instagram.presentation.SplashScreen
import com.kodex.instagram.util.icon
import com.kodex.instagram.util.TopBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramTheme {
                // A surface container using the 'background' color from the theme
                Scaffold (
                    content = {
                        Surface(modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background) {
                            val navController = rememberNavController()
                            val authViewModel: AuthenticationViewModel = hiltViewModel()
                            InstagramCloneApp(navController, authenticationViewModel = authViewModel)
                        }
                    }
                )
            }
        }
    }
}


@Composable
fun InstagramCloneApp(navController: NavHostController, authenticationViewModel : AuthenticationViewModel) {
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route){

        composable(route = Screens.LoginScreen.route){
            LoginScreen(navController = navController,
                viewModel = authenticationViewModel)
        }
        composable(route = Screens.SignUpScreen.route){
            SignUpScreen(navController, authenticationViewModel)
        }
        composable(route=Screens.SplashScreen.route){
            SplashScreen(navController = navController, authViewModel = authenticationViewModel)
        }
        composable(route = Screens.FeedsScreen.route){
            FeedsScreen(navController = navController)
        }
        composable(route = Screens.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(route = Screens.SearchScreen.route){
            SearchScreen(navController = navController)
        }
    }
}

