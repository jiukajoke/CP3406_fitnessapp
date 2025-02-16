package com.example.fitnessapp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fitnessapp.ui.theme.FitnessappTheme

// 导入导航和其他必要的 Compose 组件
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitnessapp.ui.BottomNavigationBar
import com.example.fitnessapp.ui.HomeScreen
import com.example.fitnessapp.ui.WorkoutScreen
import com.example.fitnessapp.ui.DietScreen
import com.example.fitnessapp.ui.StatsScreen

import android.os.Bundle

import androidx.compose.foundation.layout.padding

import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessappTheme {
                // 使用你的导航结构
                AppNavigation()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessappTheme {
        Greeting("Android")
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