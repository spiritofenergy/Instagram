package com.kodex.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kodex.instagram.presentation.Authentication.AuthenticationViewModel
import com.kodex.instagram.presentation.Authentication.FeedsScreen
import com.kodex.instagram.ui.theme.InstagramTheme
import com.kodex.instagram.util.Screens
import com.kodex.instagram.presentation.Authentication.LoginScreen
import com.kodex.instagram.presentation.Authentication.SignUpScreen
import com.kodex.instagram.presentation.SplashScreen
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
                    val authViewModel: AuthenticationViewModel = hiltViewModel()
                    InstagramCloneApp(navController, authenticationViewModel = authViewModel)
                }
            }
        }
    }
    
}
@Composable
fun InstagramCloneApp(navController: NavHostController, authenticationViewModel : AuthenticationViewModel) {
    NavHost(navController = navController , startDestination = Screens.SplashScreen.route){
        composable(route = Screens.LoginScreen.route){
            LoginScreen(navController = navController,
                authViewModel = authenticationViewModel)
        }
        composable(route = Screens.SignUpScreen.route){
            SignUpScreen()
        }
        composable(route = Screens.SignUpScreen.route){
            SplashScreen(navController = navController, authViewModel = authenticationViewModel )
        }
        composable(route = Screens.FeedsScreen.route){
            FeedsScreen(navController = navController,
                authViewModel = authenticationViewModel)
        }
    }
}

