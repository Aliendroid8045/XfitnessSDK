package com.example.xfit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xfit.data.repository.HelpRepository

class HelpFactory(private val helpRepository: HelpRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HelpViewModel(helpRepository) as T
        }
    }
