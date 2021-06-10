package com.example.baseclean.di

import com.example.baseclean.domain.gateways.tvshow.TvShowDataSource
import com.example.baseclean.domain.gateways.tvshow.TvShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTvShowRepository(tvShowDataSource: TvShowDataSource): TvShowRepository {
        return TvShowRepository(tvShowDataSource)
    }

    /*@Singleton
    @Provides
    fun provideTvShowInteractor(tvShowRepository: TvShowRepository): TvShowInteractors {
        return TvShowInteractors(
            getPopularTvShows = GetPopularTvShows(tvShowRepository)
        )
    }*/
}