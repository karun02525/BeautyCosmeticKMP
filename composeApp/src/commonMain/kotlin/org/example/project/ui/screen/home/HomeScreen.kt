package org.example.project.ui.screen.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.bell_icon
import beautycosmetickmp.composeapp.generated.resources.search_icon
import org.jetbrains.compose.resources.painterResource

@Preview
@Composable
fun HomeScreen() {


    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar()
        },
        bottomBar = {
            BottomAppBar()
        }
    ) {

    }




}