package com.example.fitnessapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.viewmodel.MainViewModel
import com.example.fitnessapp.data.model.Workout
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HistoryScreen(navController: NavController, viewModel: MainViewModel) {
    val workouts = viewModel.workouts.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("📋 Workout History", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        if (workouts.value.isEmpty()) {
            Text("No workout records yet.")
        } else {
            LazyColumn {
                items(workouts.value) { workout ->
                    WorkoutItem(workout = workout, onDelete = {
                        viewModel.deleteWorkout(it)
                    })
                }
            }
        }
    }
}

@Composable
fun WorkoutItem(workout: Workout, onDelete: (Workout) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = workout.description)
            Text(
                text = "Time: ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date(workout.timestamp))}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(6.dp))
            Button(onClick = { onDelete(workout) }) {
                Text("Delete")
            }
        }
    }
}
