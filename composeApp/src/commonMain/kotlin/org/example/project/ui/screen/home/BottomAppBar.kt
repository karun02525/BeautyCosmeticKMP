package org.example.project.ui.screen.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.btn_1
import beautycosmetickmp.composeapp.generated.resources.btn_2
import beautycosmetickmp.composeapp.generated.resources.btn_3
import beautycosmetickmp.composeapp.generated.resources.btn_4
import beautycosmetickmp.composeapp.generated.resources.btn_5
import org.example.project.ui.screen.home.MenuItem.Companion.listItem
import org.example.project.ui.theme.GREEN
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Preview
@Composable
fun BottomAppBar() {
    LazyRow (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .background(GREEN, shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
    ) {
        items(listItem){
            IconBox(it)
        }
    }

}

data class MenuItem(val id:Int,val name:String,val icon: DrawableResource){
    companion object {
        val listItem = listOf(
            MenuItem(1,"Explore",Res.drawable.btn_1),
            MenuItem(2,"Cart",Res.drawable.btn_2),
            MenuItem(3,"Wishes",Res.drawable.btn_3),
            MenuItem(4,"My Order",Res.drawable.btn_4),
            MenuItem(5,"Profile",Res.drawable.btn_5),
        )
    }
}


@Composable
private fun IconBox(item: MenuItem) {
    Column(
        modifier = Modifier.padding(vertical = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(painter = painterResource(item.icon),
            contentDescription = item.name,
            modifier = Modifier
                .size(20.dp)
        )

        Text(item.name,
            fontSize = 10.sp,
            color = Color.White,
            modifier = Modifier.
            padding(top = 2.dp)
        )
    }
}