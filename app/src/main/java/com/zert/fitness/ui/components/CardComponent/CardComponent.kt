package com.zert.fitness.ui.components.CardComponent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.zert.fitness.R

@Composable
fun CardComponent(
    modifier: Modifier = Modifier,
    content: @Composable() () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.gray),
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
    ) {
        content()
    }
}
