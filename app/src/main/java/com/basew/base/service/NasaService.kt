package com.basew.base.service

import com.basew.base.common.api.NasaApiEndPoints.GET_PICTURE_OF_DAY
import com.basew.base.data.model.response.AstronomyPictureOfTheDayApiModel
import retrofit2.http.Body
import retrofit2.http.GET

interface NasaService {

    @GET(GET_PICTURE_OF_DAY)
    suspend fun getPictureOfDay(): AstronomyPictureOfTheDayApiModel


}