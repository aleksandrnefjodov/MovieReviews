package com.example.moviereviews.movie_reviews.data.data_source.remote.dto

import com.google.gson.annotations.SerializedName

data class MoviesListDto(
    @SerializedName("copyright") val copyright: String,
    @SerializedName("has_more") val hasMore: Boolean,
    @SerializedName("num_results") val numResults: Int,
    @SerializedName("results") val results: List<MovieDto>,
    @SerializedName("status") val status: String
)