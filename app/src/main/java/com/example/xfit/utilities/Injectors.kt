package com.example.xfit.utilities

import com.example.xfit.data.repository.WorkOutRepository
import com.example.xfit.network.WorkOutTypeNetworkService
import com.example.xfit.viewmodel.WorkOutFactory

object Injectors {

    fun provideWorkOutFactory(): WorkOutFactory {
        val repository = WorkOutRepository(WorkOutTypeNetworkService.createWorkOutTypeService())
        return WorkOutFactory(repository)
    }
}