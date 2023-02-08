package com.vipulasri.jetinstagram.ui.home

import android.text.Layout.Alignment
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.vipulasri.jetinstagram.MainViewModel
import com.vipulasri.jetinstagram.R

@Composable
fun Add(viewModel: MainViewModel) {
val context = LocalContext.current
    Scaffold(Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)) {
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = stringResource(id = R.string.image_for_upload),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .clickable {
                        Toast
                            .makeText(context, "1Выбрано фото", Toast.LENGTH_SHORT)
                            .show()
                    }

            )

            Row {
                Button( onClick = {
                    Toast.makeText(context, "2Загружено фото", Toast.LENGTH_SHORT).show()
                }, modifier = Modifier.padding(8.dp)) {
                    Text(text = "Custom colors")
                }
            }
            Button(onClick = {
                viewModel.uploadImage()
                Toast.makeText(context, "3Загружено фото", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Загрузить фото")
            }
            Button(modifier = Modifier.padding(top = 26.dp),
                onClick = {

                       // TODO

                }) {
                Text(text = "Constants.Keys.UPDATE_NOTE")

            }
        }
        }
    }


@Preview
@Composable
fun ShowAdd(){
}
