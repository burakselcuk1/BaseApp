package com.basew.base.repository

import com.basew.base.common.Resource
import com.basew.base.ui.main.model.AstronomyPictureOfTheDayUiModel

interface NasaRepository {

        suspend fun getPictureOfDay(): Resource<AstronomyPictureOfTheDayUiModel>

}