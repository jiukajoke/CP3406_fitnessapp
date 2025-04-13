package com.example.fitnessapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String,
    val timestamp: Long = System.currentTimeMillis()
)
