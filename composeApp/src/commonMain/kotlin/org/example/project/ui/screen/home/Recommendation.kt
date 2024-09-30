package org.example.project.ui.screen.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.item1
import beautycosmetickmp.composeapp.generated.resources.item2
import beautycosmetickmp.composeapp.generated.resources.item3
import beautycosmetickmp.composeapp.generated.resources.item3_5
import beautycosmetickmp.composeapp.generated.resources.item4
import org.example.project.ui.screen.home.ItemRecommendation.Companion.itemRecommendation
import org.example.project.ui.theme.GREEN
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Preview
@Composable
fun Recommendation() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Recommendation",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
            )
            Text(
                "See all",
                fontSize = 10.sp,
                color = GREEN,
                modifier = Modifier
            )
        }

        RecommendationList()

    }
}

@Composable
fun RecommendationList() {
    EasyGrid(nColumns = 2, items = itemRecommendation) {
        Item(it)
    }
}

@Composable
fun <T> EasyGrid(nColumns: Int, items: List<T>, content: @Composable (T) -> Unit) {
    Column(Modifier.padding(10.dp)) {
        for (i in items.indices step nColumns) {
            Row {
                for (j in 0 until nColumns) {
                    if (i + j < items.size) {
                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier.weight(1f)
                        ) {
                            content(items[i + j])
                        }
                    } else {
                        Spacer(Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}

@Composable
private fun Item(item: ItemRecommendation) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
            ,
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(item.icon),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(120.dp)
            )
        }
        Text(
            "$"+item.price,
            textAlign = TextAlign.Start,
            fontSize = 13.sp,
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



data class ItemRecommendation(val name:String, val icon:DrawableResource, val price:Int, val rating:Double){
    companion object {
        val itemRecommendation = listOf(
            ItemRecommendation(name = "edu perfume",
                icon = Res.drawable.item1,
                price = 233,
                rating = 3.3
                ),
            ItemRecommendation(name = "Herbal",
                icon = Res.drawable.item2,
                price = 33,
                rating = 4.3
                ),
            ItemRecommendation(name = "muskara",
                icon = Res.drawable.item3,
                price = 53,
                rating = 2.3
                ),
            ItemRecommendation(name = "Xedsl",
                icon = Res.drawable.item4,
                price = 612,
                rating = 5.3
                ),
            ItemRecommendation(name = "oxe perfume",
                icon = Res.drawable.item3_5,
                price = 743,
                rating = 3.1
                ),
        )
    }
}