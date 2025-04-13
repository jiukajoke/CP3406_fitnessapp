package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.example.fitnessapp.data.local.AppDatabase
import com.example.fitnessapp.repository.FitnessRepository
import com.example.fitnessapp.ui.navigation.AppNavigation
import com.example.fitnessapp.ui.theme.FitnessappTheme
import com.example.fitnessapp.viewmodel.MainViewModel
import com.example.fitnessapp.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "fitness-db"
        ).build()
        val repository = FitnessRepository(db.workoutDao())
        val viewModel = MainViewModel(repository)

        setContent {
            FitnessappTheme {
                AppNavigation(viewModel)
            }
        }
    }
}