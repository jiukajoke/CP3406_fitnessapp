package com.example.fitnessapp.ui
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

import androidx.navigation.NavController


import androidx.navigation.compose.NavHost


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.*
import com.example.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
            composable("home") { HomeScreen(navController) }
            composable("workout") { WorkoutScreen(navController) }
            composable("diet") { DietScreen(navController) }
            composable("stats") { StatsScreen(navController) }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        listOf("home" to "🏠", "workout" to "💪", "diet" to "🍎", "stats" to "📊").forEach { (route, icon) ->
            NavigationBarItem(
                icon = { Text(icon, fontSize = 20.sp) },
                label = { Text(route.capitalize()) },
                selected = false,
                onClick = { navController.navigate(route) }
            )
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("🏋️ Training & Food Log", fontSize = 24.sp)
        Spacer(Modifier.height(10.dp))
        Button(onClick = { navController.navigate("workout") }) { Text("Record Training") }
        Spacer(Modifier.height(10.dp))
        Button(onClick = { navController.navigate("diet") }) { Text("Record Food Log") }
        Spacer(Modifier.height(10.dp))
        Button(onClick = { navController.navigate("stats") }) { Text("View Statistics") }
    }
}

@Composable
fun WorkoutScreen(navController: NavController) {
    var workout by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("💪 Record Training", fontSize = 24.sp)
        Spacer(Modifier.height(10.dp))
        BasicTextField(
            value = workout,
            onValueChange = { workout = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        Button(onClick = { /* Save data function */ }) { Text("Save") }
    }
}

@Composable
fun DietScreen(navController: NavController) {
    var food by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("🍎 Record Food Log", fontSize = 24.sp)
        Spacer(Modifier.height(10.dp))
        BasicTextField(
            value = food,
            onValueChange = { food = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        Button(onClick = { /* Save data function */ }) { Text("Save") }
    }
}

@Composable
fun StatsScreen(navController: NavController) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("📊 View Statistics", fontSize = 24.sp)
        Spacer(Modifier.height(10.dp))
        Text("Here you will see your training & eating statistics")
    }
}
