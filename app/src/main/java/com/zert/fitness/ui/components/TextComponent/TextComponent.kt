package com.zert.fitness.ui.components.TextComponent

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.zert.fitness.R

@Composable
fun TextComponent(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    textColor: Color = colorResource(id = R.color.black),
    fontSize: TextUnit = 12.sp

) {
    Text(
        fontWeight = fontWeight,
        fontSize = fontSize,
        text = text,
        color = textColor,
        modifier = modifier
    )
}
