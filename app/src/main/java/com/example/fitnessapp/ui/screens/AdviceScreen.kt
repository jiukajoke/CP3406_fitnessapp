package com.example.fitnessapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AdviceScreen(navController: NavController) {
    var adviceText by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("AI fitness advice", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                loading = true
                // Simulating ChatGPT responses
                adviceText = "Today, I recommend doing 30 minutes of aerobic exercise, such as brisk walking or cycling, plus 15 minutes of core training (such as sit-ups and planks). Pay attention to stretching and replenishing water. In terms of diet, it is recommended to consume high-protein and low-fat foods, such as boiled eggs, chicken breast, oatmeal, etc."
                loading = false
            }
        ) {
            Text("Get today's fitness tips123")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (loading) {
            CircularProgressIndicator()
        } else if (adviceText.isNotBlank()) {
            Text(adviceText)
        }
    }
}
