package org.example.project.ui.screen.home


import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
        LazyColumn (
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxSize()

        ) {
            item {
                BannerCarouselWidget()
            }
            categorySection()
            recommendationTile()

        }
    }
}