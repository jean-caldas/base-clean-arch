package com.example.baseclean.data.tvshow.network

import com.google.gson.annotations.SerializedName

data class ResultDTO(
    var page: Int,
    @SerializedName("results")
    var entities: List<TvShowDTO>,
    @SerializedName("total_pages")
    var totalPages: Int,
    @SerializedName("total_results")
    var totalResults: Int
)