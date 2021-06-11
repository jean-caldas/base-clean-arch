package com.example.baseclean.data.tvshow.network

import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.ui.common.mappers.EntityMapper
import javax.inject.Inject

class TvShowMapper @Inject constructor() : EntityMapper<TvShowDTO, TvShow> {
    override fun mapFromEntity(entity: TvShowDTO): TvShow {
        return TvShow(
            id = entity.id,
            name = entity.name
        )
    }

    override fun mapToEntity(domainModel: TvShow): TvShowDTO {
        return TvShowDTO(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    fun mapFromEntityList(entities: List<TvShowDTO>): List<TvShow> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapFromResult(result: ResultDTO):List<TvShow> {
        return result.entities.map { mapFromEntity(it) }
    }
}