package com.lnmcode.myweather.datasource.usecase.cache

import com.lnmcode.myweather.datasource.helper.cache.ListLocationRepository
import com.lnmcode.myweather.domain.model.list_location.ListLocation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber

class ListLocationUseCaseImpl(
    private val listLocationRepository: ListLocationRepository
) : ListLocationUseCase {
    override suspend fun insertLocation(
        listLocation: ListLocation,
        onSuccess: () -> Unit
    ): Flow<Long> = flow {
        val result = listLocationRepository.insertLocation(listLocation.toEntity())
        emit(result)
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO).catch { e ->
        Timber.e(e.message)
    }

    override suspend fun insertOrUpdateLocation(
        listLocation: ListLocation,
        onSuccess: () -> Unit
    ): Flow<Boolean> = flow {
        listLocationRepository.insertOrUpdateCurrentLocation(listLocation.toEntity())
        emit(true)
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO).catch { e ->
        Timber.e(e.message)
    }

    override suspend fun getAllLocations(onSuccess: () -> Unit): Flow<List<ListLocation>> = flow {
        val listWeathers = listLocationRepository.getAllLocations()
        emit(listWeathers.map { it.toDomain() })
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO).catch { e ->
        Timber.e(e.message)
    }

    override suspend fun getLocation(id: Int, onSuccess: () -> Unit): Flow<ListLocation?> = flow {
        val listWeather = listLocationRepository.getLocation(id)
        if (listWeather != null) {
            emit(listWeather.toDomain())
        }
        emit(null)
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO).catch { e ->
        Timber.e(e.message)
    }
}