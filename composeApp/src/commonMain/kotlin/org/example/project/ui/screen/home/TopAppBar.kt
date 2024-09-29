package org.example.project.ui.screen.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.bell_icon
import beautycosmetickmp.composeapp.generated.resources.search_icon
import org.jetbrains.compose.resources.painterResource

@Preview
@Composable
fun TopAppBar() {
   ConstraintLayout(
     modifier = Modifier
       .fillMaxWidth()
       .padding(10.dp)
   ) {
        val (txt1,txt2,search,notification) = createRefs()
        Text("Welcome,Back",
          fontSize = 12.sp,
          color = Color.Black.copy(0.5f),
          modifier = Modifier
            .constrainAs(txt1){
            start.linkTo(parent.start)
            top.linkTo(parent.top)
          }
        )

     Text("Karun",
       fontSize = 15.sp,
       modifier = Modifier
         .constrainAs(txt2){
           start.linkTo(parent.start)
           top.linkTo(txt1.bottom)
           bottom.linkTo(parent.bottom)
         }
     )
     Image(painter = painterResource(Res.drawable.search_icon),
       contentDescription = "search",
       modifier = Modifier.size(30.dp)
         .constrainAs(search){
           end.linkTo(notification.start)
           top.linkTo(parent.top)
           bottom.linkTo(parent.bottom)
         }
     )

     Image(painter = painterResource(Res.drawable.bell_icon),
       contentDescription = "notification",
       modifier = Modifier
         .padding(start = 10.dp)
         .size(30.dp)
         .constrainAs(notification){
           top.linkTo(parent.top)
           end.linkTo(parent.end)
           bottom.linkTo(parent.bottom)
         }
     )




   }


}