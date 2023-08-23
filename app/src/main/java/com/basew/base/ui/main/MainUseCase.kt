package com.basew.base.ui.main

import com.basew.base.common.Resource
import com.basew.base.repository.NasaRepository
import com.basew.base.ui.main.model.AstronomyPictureOfTheDayUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val nasaRepository: NasaRepository
) {
    fun execute(): Flow<Resource<AstronomyPictureOfTheDayUiModel>> {
        return flow {
            val pictureOfDay = nasaRepository.getPictureOfDay()
            emit(pictureOfDay)
        }.flowOn(Dispatchers.IO)
    }
}
