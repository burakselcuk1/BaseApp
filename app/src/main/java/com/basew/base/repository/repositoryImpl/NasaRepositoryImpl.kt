package com.basew.base.repository.repositoryImpl

import com.basew.base.common.Resource
import com.basew.base.repository.NasaRepository
import com.basew.base.service.NasaService
import com.basew.base.ui.main.model.AstronomyPictureOfTheDayUiModel
import com.basew.base.ui.main.model.MainUiMapper
import javax.inject.Inject

class NasaRepositoryImpl @Inject constructor(
    private val nasaService: NasaService,
    private val mapper: MainUiMapper
) : NasaRepository {

    override suspend fun getPictureOfDay(): Resource<AstronomyPictureOfTheDayUiModel> = try {
        val apiModel = nasaService.getPictureOfDay()
        val uiModel = mapper.mapToUiModel(apiModel)
        Resource.Success(uiModel)
    } catch (e: Exception) {
        Resource.Error(e)
    }
}

