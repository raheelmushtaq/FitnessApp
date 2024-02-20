package com.zert.fitness.ui.components.TestItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zert.fitness.R
import com.zert.fitness.data.data_source.entities.Exercises
import com.zert.fitness.ui.components.CardComponent.CardComponent
import com.zert.fitness.ui.components.TextComponent.TextComponent

@Composable
fun TestItem(modifier: Modifier, item: Exercises, onItemClick: (Exercises) -> Unit = {}) {
    Column {
        CardComponent {

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextComponent(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    text = item.title,
                    textColor = colorResource(id = R.color.black),
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null,
                    modifier = Modifier
                        .width(15.dp)
                        .height(30.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun TestItemPreview() {
    Column {
        TestItem(modifier = Modifier, item = Exercises("ABC", "node"))
    }
}