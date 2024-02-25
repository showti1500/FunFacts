package com.kizzy.funfacts.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kizzy.funfacts.ui.InputViewModel

@Composable
fun navGraph(userInputViewModel: InputViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.INPUT_SCREEN) {
        composable(Routes.INPUT_SCREEN) {
            InputScreen(navController,userInputViewModel)
        }

        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(userInputViewModel)
        }
    }

}