package com.example.xfit.data.repository

import com.example.xfit.data.WorkoutType
import com.example.xfit.network.WorkOutTypeNetworkService

class WorkOutRepository(private val workoutTypeNetworkService: WorkOutTypeNetworkService) {


    suspend fun makeWorkoutTypeCall(): List<WorkoutType> {
       return workoutTypeNetworkService.getWorkout()
    }

}