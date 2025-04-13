package com.example.fitnessapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitnessapp.data.model.Workout

@Database(entities = [Workout::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
}
