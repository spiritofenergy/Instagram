package com.example.instagramclone.presentation

import android.app.Activity
import android.content.Intent
import android.view.animation.OvershootInterpolator
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.instagramclone.R
import com.example.instagramclone.presentation.Authentication.AuthenticationViewModel
import com.example.instagramclone.presentation.Main.UserViewModel
import com.example.instagramclone.service.LoadService
import com.example.instagramclone.util.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController,authViewModel: AuthenticationViewModel){
    val context = LocalContext.current
    val activity = if (context is Activity)context else null
    val authValue = authViewModel.isUserAuthenticated
    val scale = remember{
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        activity?.startService(Intent(context, LoadService::class.java))
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(durationMillis = 1500, easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            })
        )
        delay(1000)
        if(authValue){
            navController.navigate(Screens.FeedsScreen.route){
                popUpTo(Screens.SplashScreen.route){
                    inclusive = true
                }
            }
        }
        else{
            navController.navigate(Screens.LoginScreen.route){
                popUpTo(Screens.SplashScreen.route){
                    inclusive = true
                }
            }
        }
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.ic_instagram_logo),
        contentDescription = "Splash Screen Logo", modifier = Modifier.scale(scale.value))
    }
}