package org.example.project.ui.screen.splash

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import beautycosmetickmp.composeapp.generated.resources.Res
import beautycosmetickmp.composeapp.generated.resources.intro
import org.example.project.ui.theme.GREEN
import org.jetbrains.compose.resources.painterResource

@Preview
@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Image(painter = painterResource(Res.drawable.intro),"")

        Spacer(Modifier.weight(1f))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Black)) {
                    append("Unveiling a World")
                }
                withStyle(style = SpanStyle(color = GREEN)) {
                    append("  Beauty & Cosmetic")
                }
                withStyle(style = SpanStyle(color = Black)) {
                    append(" Products!")
                }
            },
            fontSize = 20.sp,
            lineHeight = TextUnit(25f, TextUnitType.Sp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        )


        Spacer(Modifier.weight(1f))
        Text(
            text = "Browse the latest styles from top brands\n" +
                    "Get personalized recommendations\n" +
                    "Enjoy fast, free shipping",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            lineHeight = TextUnit(23f, TextUnitType.Sp),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(Modifier.weight(1f))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = GREEN,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            elevation = ButtonDefaults.buttonElevation(3.dp),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            Text("Let's Get Started", fontWeight = FontWeight.SemiBold)
        }

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Already have an account?")
                }
                withStyle(style = SpanStyle(color = GREEN)) {
                    append(" Sign In")
                }
            },
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            lineHeight = TextUnit(23f, TextUnitType.Sp),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.weight(1f))
    }
}