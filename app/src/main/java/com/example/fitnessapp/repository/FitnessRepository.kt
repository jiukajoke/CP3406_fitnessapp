package com.example.fitnessapp.repository

import com.example.fitnessapp.data.local.WorkoutDao
import com.example.fitnessapp.data.model.Workout
import kotlinx.coroutines.flow.Flow

class FitnessRepository(private val workoutDao: WorkoutDao) {

    suspend fun addWorkout(description: String) {
        workoutDao.insertWorkout(Workout(description = description))
    }

    fun getWorkouts(): Flow<List<Workout>> = workoutDao.getAllWorkouts()

    suspend fun deleteWorkout(workout: Workout) {
        workoutDao.deleteWorkout(workout)
    }
}
