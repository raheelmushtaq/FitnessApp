package com.zert.fitness.ui.components.appstate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zert.fitness.ui.components.bottomtab.BottomTabBarsItems

@Composable
fun rememberAppState(
    navHostController: NavHostController = rememberNavController()
) = remember(navHostController) {
    AppState(navHostController)
}

@Stable
class AppState(
    val navHostController: NavHostController
) {

    private val routes = listOf(
        BottomTabBarsItems.Workout,
        BottomTabBarsItems.History,
        BottomTabBarsItems.Account,
    ).map { it.destination.route }

    val shouldShowBottomBar: Boolean
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination?.route in routes
}