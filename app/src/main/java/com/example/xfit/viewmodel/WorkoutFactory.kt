package com.example.xfit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xfit.data.repository.WorkoutRepository

class WorkoutFactory(private val workoutRepository: WorkoutRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorkoutViewModel(workoutRepository) as T
    }

}