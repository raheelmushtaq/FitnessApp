package com.zert.fitness.ui.components.bottomtab

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zert.fitness.ui.screens.destinations.AccountsScreenDestination
import com.zert.fitness.ui.screens.destinations.HistoryScreenDestination
import com.zert.fitness.ui.screens.destinations.WorkoutScreenDestination

@Composable
fun NavigationGraph(modifier: Modifier = Modifier,navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomTabBarsItems.Workout.destination.route
    ) {
        composable(BottomTabBarsItems.Workout.destination.route) {
            WorkoutScreenDestination()
        }
        composable(BottomTabBarsItems.Account.destination.route) {
            AccountsScreenDestination()
        }
        composable(BottomTabBarsItems.History.destination.route) {
            HistoryScreenDestination()
        }
    }
}