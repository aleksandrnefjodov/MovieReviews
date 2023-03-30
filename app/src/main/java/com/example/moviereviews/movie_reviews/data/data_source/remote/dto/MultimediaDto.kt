package com.example.moviereviews.movie_reviews.data.data_source.remote.dto

import com.google.gson.annotations.SerializedName

data class MultimediaDto(
    @SerializedName("height") val height: Int?,
    @SerializedName("src") val src: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("width") val width: Int?
)