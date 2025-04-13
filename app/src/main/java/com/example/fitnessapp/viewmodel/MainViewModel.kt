package com.example.fitnessapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.repository.FitnessRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: FitnessRepository) : ViewModel() {
    fun saveWorkout(description: String) {
        viewModelScope.launch {
            repository.addWorkout(description)
        }
    }
}

class MainViewModelFactory(private val repository: FitnessRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}