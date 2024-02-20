package com.zert.fitness.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.zert.fitness.R
import com.zert.fitness.ui.screens.destinations.HomeDestination
import com.zert.fitness.ui.screens.destinations.SplashScreenDestination
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination(start = true)
@RootNavGraph(start = true)
fun SplashScreen(
    navHostController: DestinationsNavigator,
    viewModel: SplashViewModel = hiltViewModel()
) {

    val uiData = viewModel.uiData.value

    val scaffoldState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = "true", block = {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                is SplashViewModel.UIEvent.Success -> {
                    navHostController.navigate(HomeDestination()) {
                        launchSingleTop = true
                        popUpTo(SplashScreenDestination.route) {
                            inclusive = true
                        }
                    }
                }

                is SplashViewModel.UIEvent.Error -> {
                    scaffoldState.showSnackbar(
                        message = event.message,
                        duration = SnackbarDuration.Short
                    )
                }
            }

        }
    })
    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = scaffoldState,
                modifier = Modifier.padding(0.dp, 80.dp)
            )
        }) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.blue_200))
                .padding(paddingValue)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (uiData.isLoading) {
                    Spacer(modifier = Modifier.height(32.dp))
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                }
                if (uiData.isError) {
                    Button(onClick = { viewModel.fetchSkills() }) {
                        Text(text = stringResource(id = R.string.retry))
                    }
                    Spacer(modifier = Modifier.height(32.dp))

                }
            }
        }
    }

}

@Preview
@Composable
fun SplashScreenPreview() {
//    SplashScreen()

}