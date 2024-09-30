package org.example.project.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerCarouselWidget(
    banners: List<BannerModel> = listOf(
        BannerModel(imageUrl = "https://png.pngtree.com/background/20230414/original/pngtree-makeup-lipstick-foundation-cosmetics-beauty-makeup-fantasy-color-advertising-background-picture-image_2424119.jpg", contentDescription = ""),
        BannerModel(imageUrl = "https://res.cloudinary.com/conferences-and-exhibitions-pvt-ltd/image/upload/v1708084984/India_becomes_pivotal_growth_driver.jpg", contentDescription = ""),
        BannerModel(imageUrl = "https://images.news18.com/ibnlive/uploads/2021/10/makeup-kit-16349877184x3.jpg", contentDescription = ""),
        BannerModel(imageUrl = "https://franchiseindia.s3.ap-south-1.amazonaws.com/uploads/content/wi/art/5b289fdb7d3b0.jpg", contentDescription = ""),

        ),
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = {
        banners.size
    })

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(start = 10.dp, end = 16.dp),
            pageSpacing = 8.dp,
            verticalAlignment = Alignment.Top,
        ) { page ->
            BannerWidget(
                imageUrl = banners[page].imageUrl,
                contentDescription = banners[page].contentDescription
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}

@Composable
fun BannerWidget(
    imageUrl: String,
    contentDescription: String="",
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

data class BannerModel(val imageUrl:String,val contentDescription:String)