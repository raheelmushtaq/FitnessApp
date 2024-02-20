package com.zert.fitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.NavGraph
import com.zert.fitness.ui.components.appstate.rememberAppState
import com.zert.fitness.ui.components.bottomtab.BottomTabBar
import com.zert.fitness.ui.components.bottomtab.NavigationGraph
import com.zert.fitness.ui.screens.NavGraphs
import com.zert.fitness.ui.screens.destinations.SplashScreenDestination
import com.zert.fitness.ui.screens.home.Home
import com.zert.fitness.ui.theme.FitnessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val appState = rememberAppState()

                    Scaffold(bottomBar = {
                        if (appState.shouldShowBottomBar) {
                            BottomTabBar(
                                navController = appState.navHostController
                            )
                        }
                    }) { paddingValue ->
                        DestinationsNavHost(
                            navGraph = NavGraphs.root,
                            navController = appState.navHostController,
                            modifier = Modifier.padding(paddingValue)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessTheme {
    }
}