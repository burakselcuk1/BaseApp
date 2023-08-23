package com.basew.base.di

import com.basew.base.repository.NasaRepository
import com.basew.base.repository.repositoryImpl.NasaRepositoryImpl
import com.basew.base.service.NasaService
import com.basew.base.ui.main.model.MainUiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainUiMapper(): MainUiMapper {
        return MainUiMapper()
    }

    @Provides
    @Singleton
    fun provideNasaRepository(
        nasaService: NasaService,
        mainUiMapper: MainUiMapper
    ): NasaRepository {
        return NasaRepositoryImpl(nasaService, mainUiMapper)
    }
}
