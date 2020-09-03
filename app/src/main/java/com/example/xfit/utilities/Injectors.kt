package com.example.xfit.utilities

import com.example.xfit.data.repository.WorkoutRepository
import com.example.xfit.network.NetworkService
import com.example.xfit.viewmodel.WorkoutFactory

object Injectors {

    fun provideWorkOutFactory(): WorkoutFactory {
        val repository = WorkoutRepository(NetworkService.createNetworkService())
        return WorkoutFactory(repository)
    }
}