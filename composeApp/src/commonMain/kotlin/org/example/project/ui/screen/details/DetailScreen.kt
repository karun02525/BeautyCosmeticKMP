package org.example.project.ui.screen.details

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.back
import beautycosmetickmp.composeapp.generated.resources.favorite
import beautycosmetickmp.composeapp.generated.resources.item1
import beautycosmetickmp.composeapp.generated.resources.item3_1
import beautycosmetickmp.composeapp.generated.resources.item3_2
import beautycosmetickmp.composeapp.generated.resources.item3_3
import beautycosmetickmp.composeapp.generated.resources.item3_4
import beautycosmetickmp.composeapp.generated.resources.item3_5
import beautycosmetickmp.composeapp.generated.resources.profile
import org.example.project.ui.screen.details.ItemDetailsPreview.Companion.itemPreview
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Preview
@Composable
fun DetailScreen() {

    Column(
        modifier = Modifier
            .padding(top = 50.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {
        Header()
        Spacer(Modifier.height(10.dp))
        ProductPreview()
        Spacer(Modifier.height(10.dp))
    }

}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.back),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(25.dp)
        )
        Image(
            painter = painterResource(Res.drawable.favorite),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(25.dp)
        )
    }
}

@Composable
fun ProductPreview() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(Res.drawable.item3_1),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(itemPreview.size) {
                Image(
                    painter = painterResource(itemPreview[it].icon),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(50.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}
data class ItemDetailsPreview(
    val icon: DrawableResource
) {
    companion object {
        val itemPreview = listOf(
            ItemDetailsPreview(icon = Res.drawable.item3_1),
            ItemDetailsPreview(icon = Res.drawable.item3_2),
            ItemDetailsPreview(icon = Res.drawable.item3_3),
            ItemDetailsPreview(icon = Res.drawable.item3_4),
            ItemDetailsPreview(icon = Res.drawable.item3_5),
        )
    }
}



