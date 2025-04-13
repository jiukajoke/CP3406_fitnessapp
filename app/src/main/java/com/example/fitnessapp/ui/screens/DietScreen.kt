package com.example.fitnessapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DietScreen(navController: NavController) {
    var dietText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("🍎 Diet Log", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = dietText,
            onValueChange = { dietText = it },
            label = { Text("Enter your meal") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            // TODO: Save diet to DB (Future)
        }) {
            Text("Save Meal")
        }
    }
}
