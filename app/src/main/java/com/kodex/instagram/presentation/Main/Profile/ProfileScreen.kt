package com.kodex.instagram.presentation.Main


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
//import com.kodex.instagram.domain.model.TabModel
//import com.kodex.instagram.presentation.Main.Profile.components.*
//import com.kodex.instagram.presentation.Toast


import android.util.Log
import androidx.compose.material.*

//import androidx.compose.runtime.R
//import androidx.compose.runtime.R.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.kodex.instagram.R
import com.kodex.instagram.domain.model.TabModel
import com.kodex.instagram.presentation.Main.Profile.MyProfile
import com.kodex.instagram.presentation.Main.Profile.components.*
//import androidx.compose.ui.tooling.data.EmptyGroup.data
import com.kodex.instagram.presentation.Profile.BottomNavigationItem
import com.kodex.instagram.presentation.Profile.BottomNavigationMenu
import com.kodex.instagram.presentation.Profile.Toast
import com.kodex.instagram.util.Response
import com.kodex.instagram.util.TopBar

@Composable
fun ProfileScreen(navController: NavController) {
    val userviewmodel: UserViewModel = hiltViewModel()
    userviewmodel.getUserInfo()

    when (val response = userviewmodel.getUserData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }
        is Response.Success -> {
            if (response.data != null) {
                val obj = response.data
                var selectedTabIndex by remember { mutableStateOf(0) }
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        TopAppBar(
                            title = {
                                Text(text = obj.name,
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 25.sp)
                            },
                            actions = {

                                Spacer(modifier = Modifier.width(10.dp))
                            },
                            backgroundColor = Color.White,
                            elevation = 10.dp
                        )
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp,
                                        start = 10.dp,
                                        bottom = 10.dp,
                                        end = 10.dp)
                            ) {
                                RoundedImage(image = rememberImagePainter(data = obj.imageUrl),
                                    modifier = Modifier
                                        .size(100.dp)
                                        .weight(3.5f)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    modifier = Modifier.weight(6.5f)
                                ) {
                                    ProfileStats(numberText = "133",
                                        text = "Posts",
                                        navController = navController)
                                    ProfileStats(numberText = obj.followers.size.toString(),
                                        text = "Followers",
                                        navController = navController)
                                    ProfileStats(numberText = obj.following.size.toString(),
                                        text = "Following",
                                        navController = navController)
                                }
                            }
                        }
                        MyProfile(
                            displayName = obj.name,
                            bio = obj.bio,
                            url = obj.url
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            ActionButton(
                                text = "Edin Profile",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.45f)
                                    .height(35.dp)
                                    .clickable {

                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        TabView(tabModels = listOf(
                            TabModel(image = painterResource(id = R.drawable.ic_grid),
                                text = "Posts"),
                            TabModel(image = painterResource(id = R.drawable.ic_reels),
                                text = "Reels"),
                            TabModel(image = painterResource(id = R.drawable.ic_igtv),
                                text = "Igtv")
                         )){
                            selectedTabIndex = it
                        }
                        when(selectedTabIndex){
                            0 ->
                                PostsSelection(
                                    posts = listOf(
                                        painterResource(id = R.drawable.banner1),
                                        painterResource(id = R.drawable.banner2),
                                        painterResource(id = R.drawable.banner3),
                                        painterResource(id = R.drawable.banner4),
                                        painterResource(id = R.drawable.banner5),
                                )
                        }
                    }
                }
            }
        }

        is Response.Error -> {
            Toast(message = response.message)
            Log.d("successful", "Ошибка загрузки")
        }
    }



    userviewmodel.setUserInfo(
        name = "Hobel Karl Dao",
        userName = "Gastero 34 90",
        bio = "Dikens 34 567",
        websiteUrl = "https//seostor.ru"

    )

    Scaffold(
        topBar = {TopBar()},
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


