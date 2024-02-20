package com.zert.fitness.ui.screens.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.zert.fitness.R
import com.zert.fitness.data.data_source.entities.Exercises
import com.zert.fitness.ui.components.AppHeader
import com.zert.fitness.ui.components.TestItem.TestItem
import com.zert.fitness.utils.PaddingsConst

@Composable
@Destination()
fun HistoryScreen(navHostController: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppHeader(
            navHostController = navHostController,
            title = stringResource(id = R.string.history),
            showBackButton = false
        )
        LazyColumn(content = {
            items(arrayListOf(Exercises("hello"), Exercises("hello 1"))) {
                TestItem(modifier = Modifier, item = it)

            }
        }, modifier = Modifier.padding(PaddingsConst.appPadding))
    }
}

@Preview
@Composable
fun HomePreview() {
//    HistoryScreen(navHostController = rememberNavController())
}