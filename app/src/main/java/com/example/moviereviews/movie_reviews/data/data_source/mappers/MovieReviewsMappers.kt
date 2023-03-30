package com.example.moviereviews.movie_reviews.data.data_source.mappers

import com.example.moviereviews.movie_reviews.data.data_source.remote.dto.MovieDto
import com.example.moviereviews.movie_reviews.domain.model.MovieReview

fun MovieDto.toMovieReview(): MovieReview {
    return MovieReview(
        displayTitle = displayTitle,
        byline = byline,
        publicationDate = publicationDate,
        headline = headline,
        summaryShort = summaryShort,
        linkUrl = link.url,
        multimediaType = multimedia.type,
        multimediaSrc = multimedia.src,
        multimediaWidth = multimedia.width,
        multimediaHeight = multimedia.height,
    )
}