package org.example.project.ui.screen.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
        LazyColumn(
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxSize()
        ) {
            item {
                BannerCarouselWidget()
                Spacer(Modifier.height(10.dp))
                Categories()
                Spacer(Modifier.height(10.dp))
                Recommendation()
            }
        }
    }


}