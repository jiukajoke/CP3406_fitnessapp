package com.example.fitnessapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.viewmodel.MainViewModel

@Composable
fun WorkoutScreen(navController: NavController, viewModel: MainViewModel) {
    var workoutText by remember { mutableStateOf("") }
    var showConfirmation by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("💪 Workout Log", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = workoutText,
            onValueChange = { workoutText = it },
            label = { Text("Enter your workout") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            if (workoutText.isNotBlank()) {
                viewModel.saveWorkout(workoutText)
                workoutText = ""
                showConfirmation = true
            }
        }) {
            Text("Save Workout")
        }
        if (showConfirmation) {
            Spacer(modifier = Modifier.height(10.dp))
            Text("Workout saved!", color = MaterialTheme.colorScheme.primary)
        }
    }
}