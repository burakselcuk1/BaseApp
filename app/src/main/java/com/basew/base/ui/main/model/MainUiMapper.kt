package com.basew.base.ui.main.model

import com.basew.base.data.model.response.AstronomyPictureOfTheDayApiModel

class MainUiMapper {
    fun mapToUiModel(apiModel: AstronomyPictureOfTheDayApiModel): AstronomyPictureOfTheDayUiModel {
        return AstronomyPictureOfTheDayUiModel(
            title = apiModel.title,
            url = apiModel.url,
            copyright = apiModel.copyright,
            date = apiModel.date,
            explanation = apiModel.explanation,
            hdurl = apiModel.hdurl,
            media_type = apiModel.media_type,
            service_version = apiModel.service_version
        )
    }
}
