package com.zert.fitness.ui.screens.workout_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.zert.fitness.R
import com.zert.fitness.data.data_source.entities.Exercises
import com.zert.fitness.ui.components.AppHeader
import com.zert.fitness.ui.components.TestItem.TestItem
import com.zert.fitness.utils.PaddingsConst

@Composable
@Destination
fun WorkOutDetailScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize().background(color = Color.Blue)) {
        AppHeader(
            navHostController = navigator,
            title = stringResource(id = R.string.workout),
            showBackButton = false
        )
        TestItem(modifier = Modifier, item = Exercises("Work Out Detail Screen") )

    }
}

@Preview
@Composable
fun HomePreview() {
//    WorkoutScreen(navHostController = rememberNavController())
}