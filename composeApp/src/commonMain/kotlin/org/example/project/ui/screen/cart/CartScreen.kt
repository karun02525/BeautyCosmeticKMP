package org.example.project.ui.screen.cart

import androidx.compose.desktop.ui.tooling.preview.Preview
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.back
import beautycosmetickmp.composeapp.generated.resources.compose_multiplatform
import beautycosmetickmp.composeapp.generated.resources.item3_1
import beautycosmetickmp.composeapp.generated.resources.item3_2
import beautycosmetickmp.composeapp.generated.resources.item3_3
import beautycosmetickmp.composeapp.generated.resources.item3_4
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.project.ui.screen.cart.ItemCart.Companion.cartItemList
import org.example.project.ui.theme.GREEN
import org.example.project.ui.theme.GREY
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource

class CartScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.back),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable { navigator.pop() }
                        .align(Alignment.CenterStart).size(35.dp)
                )
                Text(
                    "My Cart",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(Modifier.height(15.dp))

            LazyColumn {
                items(cartItemList) {
                    ItemCard(it)
                }
            }

            Spacer(Modifier.weight(1f))
            CheckOut()
        }
    }
}

@Composable
fun CheckOut() {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(GREEN, RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
            .padding(15.dp)
    ) {

        Spacer(Modifier.height(2.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Subtotal",
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 13.sp,
            )
            Text(
                "$50",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
            )
        }
        Spacer(Modifier.height(2.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Free Delivery",
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 13.sp,
            )
            Text(
                "$10",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
            )
        }
        Spacer(Modifier.height(2.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Total Tax",
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 13.sp,
            )
            Text(
                "$3",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
            )
        }
        Spacer(Modifier.height(5.dp))
        HorizontalDivider()
        Spacer(Modifier.height(2.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Total",
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 13.sp,
            )
            Text(
                "$83",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
            )
        }
        Spacer(Modifier.height(30.dp))


        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            elevation = ButtonDefaults.buttonElevation(3.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Check Out", fontWeight = FontWeight.SemiBold)
        }
    }
}


@Composable
fun ItemCard(itemCart: ItemCart) {
    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        val (img, t1, t2, t3, view) = createRefs()

        Image(painter = painterResource(itemCart.icon),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(80.dp).clip(RoundedCornerShape(8.dp)).constrainAs(img) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            })

        Text(itemCart.name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp,
            modifier = Modifier
                .padding(start = 5.dp)
                .constrainAs(t1) {
                    top.linkTo(img.top)
                    start.linkTo(img.end)
                }.padding(top = 2.dp)
        )

        Text("$${itemCart.price}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            color = GREEN,
            modifier = Modifier.padding(start = 5.dp)
                .constrainAs(t2) {
                    top.linkTo(t1.bottom)
                    start.linkTo(t1.start)
                })

        Text("$${itemCart.totalPrice}",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 5.dp).constrainAs(t3) {
                top.linkTo(t2.bottom)
                start.linkTo(t2.start)
            })
        CountIncrement(
            modifier = Modifier
                .constrainAs(view) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            itemCart
        )
    }
}

@Composable
fun CountIncrement(modifier: Modifier, itemCart: ItemCart) {
    var count by remember { mutableStateOf(itemCart.itemCount) }
    Box(
        modifier = modifier
            .width(65.dp)
            .background(GREY, RoundedCornerShape(8.dp))
            .padding(2.dp), contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier.clickable { count-- }
                .align(Alignment.CenterStart)
                .size(20.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = vectorResource(Res.drawable.compose_multiplatform),
                contentDescription = "Add"
            )

        }
        Text(
            "$count", fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.Center)

        )
        Box(
            modifier = Modifier.clickable { count++ }
                .align(Alignment.CenterEnd)
                .size(20.dp)
                .background(GREEN, RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
        }
    }
}


data class ItemCart(
    val icon: DrawableResource,
    val name: String,
    val price: Int,
    var totalPrice: Int,
    val itemCount: Int
) {
    companion object {
        val cartItemList = listOf(
            ItemCart(icon = Res.drawable.item3_1, "Jane Coat", 45, 53, 4),
            ItemCart(icon = Res.drawable.item3_2, "Pink singlet", 15, 53, 1),
            ItemCart(icon = Res.drawable.item3_3, "Plaid shirt", 34, 87, 3),
            ItemCart(icon = Res.drawable.item3_4, "Orange women's sweater", 14, 123, 4),

            )
    }
}



