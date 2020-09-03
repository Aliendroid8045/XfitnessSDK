package com.example.xfit.data.repository

import com.example.xfit.data.WorkoutType
import com.example.xfit.network.NetworkService

class WorkoutRepository(private val workoutTypeNetworkService: NetworkService) {


    suspend fun makeWorkoutTypeCall(): List<WorkoutType> {
       return workoutTypeNetworkService.getWorkout()
    }

}