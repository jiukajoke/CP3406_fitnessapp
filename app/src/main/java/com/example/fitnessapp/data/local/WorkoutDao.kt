package com.example.fitnessapp.data.local

import androidx.room.*
import com.example.fitnessapp.data.model.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: Workout)

    @Query("SELECT * FROM workouts ORDER BY timestamp DESC")
    fun getAllWorkouts(): Flow<List<Workout>>

    @Delete
    suspend fun deleteWorkout(workout: Workout)
}
