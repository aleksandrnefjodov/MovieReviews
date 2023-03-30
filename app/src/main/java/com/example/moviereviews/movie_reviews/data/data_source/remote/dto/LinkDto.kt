package com.example.moviereviews.movie_reviews.data.data_source.remote.dto

import com.google.gson.annotations.SerializedName

data class LinkDto(
    @SerializedName("suggested_link_text") val suggestedLinkText: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String
)