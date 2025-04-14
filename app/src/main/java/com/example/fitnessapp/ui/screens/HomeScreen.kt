package com.example.fitnessapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("🏋️ Welcome to Fitness App", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("workout") }) {
            Text("Log Workout")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate("diet") }) {
            Text("Log Diet")
        }
        Button(onClick = { navController.navigate("history") }) {
            Text("View History")
        }
        Button(onClick = { navController.navigate("advice") }) {
            Text("Get AI recommendations")
        }

    }
}
