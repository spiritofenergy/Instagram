package com.vipulasri.jetinstagram.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vipulasri.jetinstagram.ui.MainScreen
import com.vipulasri.jetinstagram.ui.components.Constants
import com.vipulasri.jetinstagram.ui.home.Home
import com.vipulasri.jetinstagram.ui.home.Splash

sealed class NavRoute(val route: String) {
    object Splash: NavRoute(Constants.Screens.SPLASH_SCREEN)
    object Main: NavRoute(Constants.Screens.MAIN_SCREEN)
    object Home: NavRoute(Constants.Screens.HOME_SCREEN)
    object Note: NavRoute(Constants.Screens.NOTE_SCREEN)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun  InstagramNavHost (navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Home.route) {

        composable(NavRoute.Splash.route) { Splash(navController = navController) }
        composable(NavRoute.Main.route) { MainScreen(navController = navController) }
        composable(NavRoute.Home.route) { Home() }
    }
}
