package com.example.baseclean.di

import com.example.baseclean.data.tvshow.network.TvShowNetworkDataSource
import com.example.baseclean.domain.gateways.tvshow.TvShowContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class RemoteTvShow

@Module
@InstallIn(SingletonComponent::class)
abstract class TvShowRemoteModule {

    @RemoteTvShow
    @Singleton
    @Binds
    abstract fun bindRemoteTvShow(impl: TvShowNetworkDataSource): TvShowContract

}