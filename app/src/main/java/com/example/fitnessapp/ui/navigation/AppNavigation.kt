package com.example.fitnessapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.ui.components.BottomNavigationBar
import com.example.fitnessapp.ui.screens.DietScreen
import com.example.fitnessapp.ui.screens.HomeScreen
import com.example.fitnessapp.ui.screens.WorkoutScreen
import com.example.fitnessapp.viewmodel.MainViewModel
import com.example.fitnessapp.ui.screens.HistoryScreen


@Composable
fun AppNavigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("workout") { WorkoutScreen(navController, viewModel) }
            composable("diet") { DietScreen(navController) }
            composable("history") { HistoryScreen(navController, viewModel) }

        }
    }
}
