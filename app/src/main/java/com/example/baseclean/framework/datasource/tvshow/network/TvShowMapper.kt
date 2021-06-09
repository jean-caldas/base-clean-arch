package com.example.baseclean.framework.datasource.tvshow.network

import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.framework.common.mappers.EntityMapper
import javax.inject.Inject

class TvShowMapper @Inject constructor() : EntityMapper<TvShowNetworkEntity, TvShow> {
    override fun mapFromEntity(entity: TvShowNetworkEntity): TvShow {
        return TvShow(
            id = entity.id,
            name = entity.name
        )
    }

    override fun mapToEntity(domainModel: TvShow): TvShowNetworkEntity {
        return TvShowNetworkEntity(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    fun mapFromEntityList(entities: List<TvShowNetworkEntity>): List<TvShow> {
        return entities.map { mapFromEntity(it) }
    }
}