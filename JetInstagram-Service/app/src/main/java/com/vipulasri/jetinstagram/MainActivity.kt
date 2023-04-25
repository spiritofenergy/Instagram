package com.vipulasri.jetinstagram

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.vipulasri.jetinstagram.navigation.InstagramNavHost
import com.vipulasri.jetinstagram.ui.MainScreen
import com.vipulasri.jetinstagram.ui.home.Splash
import com.vipulasri.jetinstagram.ui.theme.JetInstagramTheme
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {

  @ExperimentalFoundationApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    this.setContent {
      JetInstagramTheme {
        Surface(color = MaterialTheme.colors.background) {
          val navController = rememberNavController()

          InstagramNavHost(navController = rememberNavController())
        }
      }
    }
  }

}