package com.kodex.instagram.presentation.Main.Profile.components

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.kodex.instagram.domain.model.TabModel

@Composable
fun TabView (
    modifier: Modifier = Modifier,
    tabModels : List<TabModel>,
    onTabSelected : (selectedIndex: Int)-> Unit
){
    var selectedTabIndex by remember { mutableStateOf(0) }
    TabRow(selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        tabModels.forEachIndexed{index, item ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color(0xFF777777)
            )
         }
    }
}