package com.zert.fitness.ui.components.bottomtab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import com.zert.fitness.ui.screens.accounts.AccountsScreen
import com.zert.fitness.ui.screens.history.HistoryScreen
import com.zert.fitness.ui.screens.workout.WorkoutScreen

@Composable
fun NavigationGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomTabBarsItems.Workout.destination.route
    ) {
        composable(BottomTabBarsItems.Workout.destination.route) {
            WorkoutScreen(EmptyDestinationsNavigator)
        }
        composable(BottomTabBarsItems.Account.destination.route) {
            AccountsScreen()
        }
        composable(BottomTabBarsItems.History.destination.route) {
            HistoryScreen()
        }
    }
}