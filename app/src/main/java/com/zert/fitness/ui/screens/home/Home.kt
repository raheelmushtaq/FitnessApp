package com.zert.fitness.ui.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.annotation.Destination
import com.zert.fitness.ui.components.bottomtab.BottomTabBar
import com.zert.fitness.ui.components.bottomtab.NavigationGraph

@Destination()
@Composable
fun Home() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomTabBar(navController = navController) }) { paddingValue ->
        NavigationGraph(navController = navController, modifier = Modifier.padding(paddingValue))
    }
}

@Preview
@Composable
fun HomePreview() {
//    Home(navHostController = rememberNavController())
}