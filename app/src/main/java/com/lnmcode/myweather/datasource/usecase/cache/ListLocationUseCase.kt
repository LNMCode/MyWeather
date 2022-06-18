package com.lnmcode.myweather.datasource.usecase.cache

import androidx.annotation.WorkerThread
import com.lnmcode.myweather.domain.model.list_location.ListLocation
import kotlinx.coroutines.flow.Flow


interface ListLocationUseCase {
    @WorkerThread
    suspend fun insertLocation(listLocation: ListLocation, onSuccess: () -> Unit): Flow<Long>

    @WorkerThread
    suspend fun getAllLocations(onSuccess: () -> Unit): Flow<List<ListLocation>>

    @WorkerThread
    suspend fun getLocation(id: Int, onSuccess: () -> Unit): Flow<ListLocation?>
}