package com.zert.fitness.ui.components.bottomtab

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import com.zert.fitness.R
import com.zert.fitness.ui.screens.NavGraphs
import com.zert.fitness.ui.screens.destinations.AccountsScreenDestination
import com.zert.fitness.ui.screens.destinations.DirectionDestination
import com.zert.fitness.ui.screens.destinations.HistoryScreenDestination
import com.zert.fitness.ui.screens.destinations.WorkoutScreenDestination

@Composable
fun BottomTabBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val items = listOf(
        BottomTabBarsItems.Workout,
        BottomTabBarsItems.History,
        BottomTabBarsItems.Account,
    )

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items.forEach { screen ->
            val isCurrentDestOnBackStack = navController.isRouteOnBackStack(screen.destination)
            NavigationBarItem(
                icon = {
                    Image(
                        painterResource(id = screen.icon),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(
                            colorResource(
                                id = if (isCurrentDestOnBackStack)
                                    R.color.gray
                                else
                                    R.color.blue
                            ),
                        )
                    )
                },
                label = { Text(stringResource(screen.title)) },
                selected = isCurrentDestOnBackStack,
                onClick = {
                    if (isCurrentDestOnBackStack) {
                        // When we click again on a bottom bar item and it was already selected
                        // we want to pop the back stack until the initial destination of this bottom bar item
                        navController.popBackStack(screen.destination, false)
                        return@NavigationBarItem
                    }
                    navController.navigate(screen.destination) {
                        // Pop up to the root of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(NavGraphs.root) {
                            saveState = true
                        }

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}


sealed class BottomTabBarsItems(
    val destination: DirectionDestinationSpec,
    val title: Int,
    val icon: Int
) {
    object Workout :
        BottomTabBarsItems(WorkoutScreenDestination, R.string.workout, R.drawable.nav_workout)

    object History :
        BottomTabBarsItems(HistoryScreenDestination, R.string.history, R.drawable.nav_workout)

    object Account :
        BottomTabBarsItems(AccountsScreenDestination, R.string.account, R.drawable.nav_workout)
}

@Preview
@Composable
fun PreviewBottomTab() {
    BottomTabBar(navController = rememberNavController())

}