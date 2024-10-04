package org.example.project.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.favorite
import beautycosmetickmp.composeapp.generated.resources.item1
import beautycosmetickmp.composeapp.generated.resources.item2
import beautycosmetickmp.composeapp.generated.resources.item3
import beautycosmetickmp.composeapp.generated.resources.item3_5
import beautycosmetickmp.composeapp.generated.resources.item4
import org.example.project.ui.components.EasyGrid
import org.example.project.ui.screen.home.ItemRecommendation.Companion.itemRecommendation
import org.example.project.ui.theme.GREEN
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


fun LazyListScope.recommendationTile(onClickDetails:()->Unit) {
    item {
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "Recommendation",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
            )
            Spacer(Modifier.weight(1f))
            Text(
                "See all",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = GREEN,
                modifier = Modifier
            )
        }
    }
    item {
        RecommendationList(onClickDetails)
        Spacer(Modifier.height(80.dp))
    }
}

@Composable
private fun RecommendationList(onClickDetails: () -> Unit) {
    EasyGrid(nColumns = 2, items = itemRecommendation) {
        Item(it,onClickDetails)
    }
}

@Composable
private fun Item(item: ItemRecommendation, onClickDetails: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClickDetails() }
            .padding(horizontal=8.dp, vertical = 5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(item.icon),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .height(120.dp)
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(Res.drawable.favorite),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .align(Alignment.TopStart)
                    .size(22.dp)
            )


        }
        Text(
            "$" + item.price,
            textAlign = TextAlign.Start,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            item.name,
            textAlign = TextAlign.Start,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
        )

    }
}


data class ItemRecommendation(
    val name: String,
    val icon: DrawableResource,
    val price: Int,
    val rating: Double
) {
    companion object {
        val itemRecommendation = listOf(
            ItemRecommendation(
                name = "edu perfume",
                icon = Res.drawable.item1,
                price = 233,
                rating = 3.3
            ),
            ItemRecommendation(
                name = "Herbal",
                icon = Res.drawable.item2,
                price = 33,
                rating = 4.3
            ),
            ItemRecommendation(
                name = "muskara",
                icon = Res.drawable.item3,
                price = 53,
                rating = 2.3
            ),
            ItemRecommendation(
                name = "Xedsl",
                icon = Res.drawable.item4,
                price = 612,
                rating = 5.3
            ),
            ItemRecommendation(
                name = "oxe perfume",
                icon = Res.drawable.item3_5,
                price = 743,
                rating = 3.1
            ),
        )
    }
}









