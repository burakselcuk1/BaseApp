package com.basew.base.ui.main

import androidx.lifecycle.viewModelScope
import com.basew.base.common.Resource
import com.basew.base.ui.main.model.AstronomyPictureOfTheDayUiModel
import com.basew.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPictureOfDayUseCase: MainUseCase
) : BaseViewModel() {

    private val _pictureOfDay = MutableStateFlow<Resource<AstronomyPictureOfTheDayUiModel>?>(null)
    val pictureOfDay = _pictureOfDay.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _pictureOfDay.emit(Resource.Loading)
            getPictureOfDayUseCase.execute().collect { result ->
                _pictureOfDay.emit(result)
            }
        }
    }
}

