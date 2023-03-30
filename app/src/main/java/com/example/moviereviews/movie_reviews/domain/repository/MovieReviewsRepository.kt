package com.example.moviereviews.movie_reviews.domain.repository

import androidx.paging.PagingData
import com.example.moviereviews.movie_reviews.domain.model.MovieReview
import kotlinx.coroutines.flow.Flow

interface MovieReviewsRepository {
    suspend fun getMovieReviews(): Flow<PagingData<MovieReview>>
}