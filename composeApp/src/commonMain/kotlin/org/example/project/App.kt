package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.example.project.ui.screen.home.HomeScreen
import org.example.project.ui.screen.splash.SplashScreen
import org.example.project.ui.theme.DARK_GREY

import org.example.project.ui.theme.GREEN
import org.example.project.ui.theme.GREY
import org.example.project.ui.theme.LIGHT_GREY

@Composable
@Preview
fun App() {
    MaterialTheme {
        SplashScreen()
        HomeScreen()
    }
}