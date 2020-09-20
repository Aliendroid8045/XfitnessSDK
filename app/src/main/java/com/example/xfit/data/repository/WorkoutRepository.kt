package com.example.xfit.data.repository

import com.example.xfit.data.WorkoutType
import com.example.xfit.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkoutRepository(private val workoutTypeNetworkService: NetworkService) {

    //Make the network call on IO thread 
    suspend fun makeWorkoutTypeAPICall(): List<WorkoutType> = withContext(Dispatchers.IO) {
        workoutTypeNetworkService.getWorkout()
    }

    suspend fun makeArmsWorkoutCall(): List<WorkoutType> {
        return workoutTypeNetworkService.getArmWorkout()

    }
}