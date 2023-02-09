package com.kodex.instagram.presentation.Authentication

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import com.kodex.instagram.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kodex.instagram.domain.use_cases.AuthenticationUseCase
import com.kodex.instagram.presentation.Profile.Toast
import com.kodex.instagram.ui.theme.InstagramTheme
import com.kodex.instagram.util.Response
import com.kodex.instagram.util.Screens


@Composable
fun LoginScreen(viewModel: AuthenticationViewModel, navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val emailState = remember {mutableStateOf("") }
            val passwordState = remember {mutableStateOf("") }
            Image(
                painter = painterResource(id = R.drawable.instagram_logo),
                contentDescription = "LoginScreen Logo",
            modifier = Modifier
                .width(250.dp)
                .padding(top = 16.dp)
                .padding(8.dp)
            )
            Text(
                text = "Sing In",
            modifier = Modifier.padding(10.dp),
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif
            )
            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
            modifier = Modifier.padding(10.dp),
                label = {
                    Text(text = "Enter Your Email:")
                }
            )
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = {
                    passwordState.value = it
                },
            modifier = Modifier.padding(10.dp),
                label = {
                    Text(text = "Enter Your Password:")
                },
                visualTransformation = PasswordVisualTransformation()
            )
            Button(
                onClick = {
                viewModel.signIn(
                    email = emailState.value,
                    password = passwordState.value
                )
            }) {
                Text(text = "Sign In")
                when(val response = viewModel.signInState.value){
                    is Response.Loading ->{
                        CircularProgressIndicator(
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    is Response.Success ->{
                        if (response.data){
                            navController.navigate(Screens.FeedsScreen.route){
                                popUpTo(Screens.LoginScreen.route){
                                    inclusive = true
                                }
                            }
                        }
                        else{
                            Toast(message = "Sing In failed")
                         }
                    }
                    is Response.Error -> {
                        Toast(message = response.message)
                    }
                }
            }
            Text(text = "New User? Sign Up ", color = Color.Blue,
            modifier = Modifier.padding(8.dp)
                .clickable {
                    navController.navigate(route = Screens.SignUpScreen.route){
                        launchSingleTop = true
                    }
                })
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PrevLoginScreen(){
    InstagramTheme() {
        val viewModel:AuthenticationViewModel
        LoginScreen(navController = rememberNavController(), viewModel = viewModel() )
    }
}