package com.example.xfit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xfit.data.repository.WorkoutRepository
import com.example.xfit.network.NetworkState
import kotlinx.coroutines.launch

class WorkoutViewModel(private val workoutRepository: WorkoutRepository) : ViewModel() {

    private val _results = MutableLiveData<NetworkState>()
    val results: LiveData<NetworkState> = _results

    fun getWorkoutType() {
        _results.value = NetworkState.Loading

        viewModelScope.launch() {
            _results.value = try {
                val workoutType = workoutRepository.makeWorkoutTypeAPICall()
                NetworkState.Content(workoutType)

            } catch (t: Throwable) {
                NetworkState.Error(t)
            }
        }
    }
}