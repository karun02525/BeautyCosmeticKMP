package org.example.project.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.cat_1
import beautycosmetickmp.composeapp.generated.resources.cat_2
import beautycosmetickmp.composeapp.generated.resources.cat_3
import beautycosmetickmp.composeapp.generated.resources.cat_4
import org.example.project.ui.theme.GREEN
import org.example.project.ui.theme.LIGHT_GREY
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


fun LazyListScope.categorySection() {
      item {
          Row(
              modifier = Modifier
                  .padding(horizontal = 15.dp, vertical = 8.dp)
                  .fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
          ) {
              Text(
                  "Categories",
                  fontSize = 15.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.Black,
                  modifier = Modifier
              )
              Spacer(Modifier.weight(1f))
              Text(
                  "See all",
                  fontSize = 15.sp,
                  color = GREEN,
                  fontWeight = FontWeight.SemiBold,
                  modifier = Modifier
              )
          }
      }

    item {
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconBox(Res.drawable.cat_1, "Skincare")
            IconBox(Res.drawable.cat_2, "Make up")
            IconBox(Res.drawable.cat_3, "Hair Care")
            IconBox(Res.drawable.cat_4, "Perfurme")
        }
    }
}

@Composable
private fun IconBox(icon: DrawableResource,txt:String) {
    Column(
        modifier = Modifier.padding(vertical = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(painter = painterResource(icon),
            contentDescription = txt,
            modifier = Modifier
                .size(40.dp)
                .background(color = LIGHT_GREY, shape = CircleShape)


        )

        Text(txt,
            fontSize = 10.sp,
            color = Color.Black,
            modifier = Modifier.
            padding(top = 2.dp)
        )
    }
}