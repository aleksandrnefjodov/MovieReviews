package com.example.moviereviews.movie_reviews.domain.model

data class MovieReview(
    val displayTitle: String,
    val linkUrl: String,
    val byline: String,
    val publicationDate: String,
    val headline: String,
    val summaryShort: String,
    val multimediaType: String?,
    val multimediaSrc: String?,
    val multimediaWidth: Int?,
    val multimediaHeight: Int?
)
