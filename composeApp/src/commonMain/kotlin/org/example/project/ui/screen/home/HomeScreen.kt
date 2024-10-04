package org.example.project.ui.screen.home


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.project.ui.screen.details.DetailScreen

class HomeScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

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
                }
                categorySection()
                recommendationTile(){
                    navigator.push(DetailScreen())
                }
            }
        }
    }
}
