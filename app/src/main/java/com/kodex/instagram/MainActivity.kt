package com.kodex.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kodex.instagram.ui.theme.InstagramTheme
import com.kodex.instagram.util.Screens
import com.kodex.instagram.presentation.Authentication.LoginScreen
import com.kodex.instagram.presentation.Authentication.SignUpScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    InstagramCloneApp(navController)
                }
            }
        }
    }
    
}
@Composable
fun InstagramCloneApp(navController: NavHostController) {
    NavHost(navController = navController , startDestination = Screens.SplashScreen.route){
        composable(route = Screens.LoginScreen.route){
            LoginScreen()
        }
        composable(route = Screens.SignUpScreen.route){
            SignUpScreen()
        }
    }
}

