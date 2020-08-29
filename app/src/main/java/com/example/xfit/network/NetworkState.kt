package com.example.xfit.network

import com.example.xfit.data.WorkoutType

sealed class NetworkState {
    object Loading : NetworkState()
    data class Content(val data: List<WorkoutType>) : NetworkState()
    data class Error(val throwable: Throwable) : NetworkState()
}
