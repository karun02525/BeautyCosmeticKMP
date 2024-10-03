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
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import okio.FileSystem
import org.example.project.ui.screen.details.DetailScreen
import org.example.project.ui.theme.GREEN
import org.example.project.ui.theme.GREY
import org.example.project.ui.theme.LIGHT_GREY

@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {

        setSingletonImageLoaderFactory {
                context ->
            readAsyncImage(context)
        }


       // SplashScreen()
       // HomeScreen()
        DetailScreen()
    }
}

fun readAsyncImage(context: PlatformContext)  =
    ImageLoader.Builder(context).memoryCachePolicy(CachePolicy.ENABLED).memoryCache {
        MemoryCache.Builder().maxSizePercent(context,0.3).strongReferencesEnabled(true).build()
    }.diskCachePolicy(CachePolicy.ENABLED).networkCachePolicy(CachePolicy.ENABLED).diskCache {
        diskCacheNew()
    }.crossfade(true).logger(DebugLogger()).build()

fun diskCacheNew():DiskCache{
    return DiskCache.Builder().directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
        .maxSizeBytes(1024L * 1024 * 1024)
        .build()
}