package com.example.baseclean.di

import com.example.baseclean.data.tvshow.network.TvShowMapper
import com.example.baseclean.data.tvshow.network.TvShowNetworkDataSource
import com.example.baseclean.data.tvshow.network.TvShowService
import com.example.baseclean.domain.gateways.tvshow.TvShowContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowService: TvShowService,
        tvShowMapper: TvShowMapper
    ): TvShowContract {
        return TvShowNetworkDataSource(tvShowService, tvShowMapper)
    }

}