package com.example.moviereviews.movie_reviews.data.data_source.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("byline") val byline: String,
    @SerializedName("critics_pick") val criticsPick: Int,
    @SerializedName("date_updated") val dateUpdated: String,
    @SerializedName("display_title") val displayTitle: String,
    @SerializedName("headline") val headline: String,
    @SerializedName("link") val link: LinkDto,
    @SerializedName("mpaa_rating") val mpaaRating: String,
    @SerializedName("multimedia") val multimedia: MultimediaDto,
    @SerializedName("opening_date") val openingDate: String,
    @SerializedName("publication_date") val publicationDate: String,
    @SerializedName("summary_short") val summaryShort: String
)