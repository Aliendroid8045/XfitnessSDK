package com.example.xfit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xfit.data.repository.WorkOutRepository

class WorkOutFactory(private val workOutRepository: WorkOutRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorkoutViewModel(workOutRepository) as T
    }

}