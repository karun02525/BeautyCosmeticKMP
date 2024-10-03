package org.example.project.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import org.example.project.ui.theme.GREEN

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerCarouselWidget(
    banners: List<BannerModel> = listOf(
        BannerModel(imageUrl = "https://i.ibb.co/Zdfctzj/banner1.png", contentDescription = ""),
        BannerModel(
            imageUrl = "https://png.pngtree.com/background/20230414/original/pngtree-makeup-lipstick-foundation-cosmetics-beauty-makeup-fantasy-color-advertising-background-picture-image_2424119.jpg",
            contentDescription = ""
        ),
        BannerModel(
            imageUrl = "https://res.cloudinary.com/conferences-and-exhibitions-pvt-ltd/image/upload/v1708084984/India_becomes_pivotal_growth_driver.jpg",
            contentDescription = ""
        ),
        BannerModel(
            imageUrl = "https://images.news18.com/ibnlive/uploads/2021/10/makeup-kit-16349877184x3.jpg",
            contentDescription = ""
        ),
        BannerModel(
            imageUrl = "https://franchiseindia.s3.ap-south-1.amazonaws.com/uploads/content/wi/art/5b289fdb7d3b0.jpg",
            contentDescription = ""
        ),

        ),
) {
    val pagerState = rememberPagerState(pageCount = {
        banners.size
    })

    Column(
        modifier = Modifier
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
                .padding(top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                if (pagerState.currentPage == iteration) {
                    Spacer(
                        modifier = Modifier
                            .padding(2.dp)
                            .background(GREEN, RoundedCornerShape(30.dp))
                            .size(height = 6.dp, width = 12.dp)
                    )
                } else {
                    Spacer(
                        modifier = Modifier
                            .padding(2.dp)
                            .background(Color.LightGray, CircleShape)
                            .size(6.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BannerWidget(
    imageUrl: String,
    contentDescription: String = "",
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

data class BannerModel(val imageUrl: String, val contentDescription: String)