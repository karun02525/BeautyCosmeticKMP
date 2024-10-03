package org.example.project.ui.screen.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.ui.theme.GREEN

@Composable
fun CarouselDotsAnimation() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        repeat(5) {

            if (it == 0) {
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