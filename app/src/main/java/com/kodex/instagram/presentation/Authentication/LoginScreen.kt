package com.kodex.instagram.presentation.Authentication

import androidx.compose.foundation.Image
import com.kodex.instagram.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun LoginScreen(authViewModel: AuthenticationViewModel, navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val emailState = remember {
                mutableStateOf("")
            }
            val passwordState = remember {
                mutableStateOf("")
            }
            Image(
                painter = painterResource(id = R.drawable.instagram_photo),
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
            Button(onClick = {

            }) {

            }
        }
    }
}