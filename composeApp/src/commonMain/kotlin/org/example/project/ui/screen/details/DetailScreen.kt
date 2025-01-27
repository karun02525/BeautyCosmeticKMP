package org.example.project.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.back
import beautycosmetickmp.composeapp.generated.resources.call
import beautycosmetickmp.composeapp.generated.resources.cart
import beautycosmetickmp.composeapp.generated.resources.favorite
import beautycosmetickmp.composeapp.generated.resources.item3_1
import beautycosmetickmp.composeapp.generated.resources.item3_2
import beautycosmetickmp.composeapp.generated.resources.item3_3
import beautycosmetickmp.composeapp.generated.resources.item3_4
import beautycosmetickmp.composeapp.generated.resources.item3_5
import beautycosmetickmp.composeapp.generated.resources.message
import beautycosmetickmp.composeapp.generated.resources.profile
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.project.ui.screen.cart.CartScreen
import org.example.project.ui.screen.details.ItemDetailsPreview.Companion.itemPreview
import org.example.project.ui.theme.GREEN
import org.example.project.ui.theme.GREY
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


class DetailScreen: Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        Scaffold(
            topBar = { Header{navigator.pop()} },
            bottomBar = { BuyNow(onCart = {
                navigator.push(CartScreen())
            }) }
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
                    .verticalScroll(state = rememberScrollState())
            ) {
                Spacer(Modifier.height(50.dp))
                ProductPreview()
                Spacer(Modifier.height(10.dp))
                SellerDescription()
                Spacer(Modifier.height(70.dp))
            }
        }
    }
}

@Composable
fun BuyNow(
    onCart:()->Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = GREEN,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            elevation = ButtonDefaults.buttonElevation(3.dp),
            modifier = Modifier.weight(9f).padding(end = 10.dp)
        ) {
            Text("Buy Now", fontWeight = FontWeight.SemiBold)
        }

        Image(
            painter = painterResource(Res.drawable.cart),
            contentDescription = "",
            modifier = Modifier
                .clickable { onCart() }
                .weight(1.4f)
                .shadow(5.dp, RoundedCornerShape(6.dp))
                .size(35.dp)
                .background(GREY, RoundedCornerShape(6.dp))
                .padding(3.dp)

        )
    }
}


@Composable
fun SellerDescription() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        val (txt1,txt2,txt3,img,txt4,img1,img2,txt5) = createRefs()

        Text(
            "Herbal fragrance",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(txt1){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )

        Text(
            "$272",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(txt2){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
        )

        Text(
            "Seller",
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(txt3){
                top.linkTo(txt1.bottom)
                start.linkTo(parent.start)
            }
        )

        Image(
            painter = painterResource(Res.drawable.profile),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 5.dp)
                .size(40.dp)
                .constrainAs(img) {
                    top.linkTo(txt3.bottom)
                    start.linkTo(parent.start)
                }
        )

        Text(
            "Jemmy Hanks",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 5.dp)
                .constrainAs(txt4) {
                    top.linkTo(img.top)
                    start.linkTo(img.end)
                    bottom.linkTo(img.bottom)
                }
        )

        Image(
            painter = painterResource(Res.drawable.message),
            contentDescription = "",
            modifier = Modifier
                .padding(end = 8.dp)
                .size(35.dp)
                .constrainAs(img1) {
                    top.linkTo(img2.top)
                    end.linkTo(img2.start)
                    bottom.linkTo(img2.bottom)
                }
        )

        Image(
            painter = painterResource(Res.drawable.call),
            contentDescription = "",
            modifier = Modifier
                .size(35.dp)
                .constrainAs(img2) {
                    top.linkTo(img.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(img.bottom)
                }
        )
       Text(
            "Immerse yourself in this harmonious fusion, where nature's finest blooms and vibrant citrus notes unite to create a truly delightful fragrance experience. In perfumery, aromatic herbs are fresh and energizing raw materials. Aromatics herbs are classified in three main groups: Lavender notes; Mint notes; Aniseed The herbal fragrance ingredients provide certain physical and emotional healing properties such as energy-enhancing, " +
                    "calming and mood-lifting. Herbal perfumes .." +
                    "In perfumery, aromatic herbs are fresh1 and energizing raw materials. Aromatics herbs are classified in three main groups: Lavender notes; Mint notes; Aniseed ..." +
                    "In perfumery, aromatic herbs are fresh2 and energizing raw materials. Aromatics herbs are classified in three main groups: Lavender notes; Mint notes; Aniseed ..."+
                    "In perfumery, aromatic herbs are fresh3 and energizing raw materials. Aromatics herbs are classified in three main groups: Lavender notes; Mint notes; Aniseed ..."+
                    "In perfumery, aromatic herbs are fresh4 and energizing raw materials. Aromatics herbs are classified in three main groups: Lavender notes; Mint notes; Aniseed ...",
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            fontSize = 10.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp)
                .constrainAs(txt5) {
                    top.linkTo(img.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

    }
}

@Composable
fun Header(onBack:()->Unit) {
    Box(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.back),
            contentDescription = "",
            modifier = Modifier
                .clickable { onBack() }
                .align(Alignment.CenterStart)
                .size(35.dp)
        )
        Image(
            painter = painterResource(Res.drawable.favorite),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(35.dp)
        )
    }
}

@Composable
fun ProductPreview() {
    Column(
        modifier = Modifier.fillMaxWidth(),
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
        CarouselDotsAnimation()
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
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



