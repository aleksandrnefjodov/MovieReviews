package com.example.moviereviews.movie_reviews.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.moviereviews.movie_reviews.data.data_source.remote.MovieReviewsApi
import com.example.moviereviews.movie_reviews.domain.model.MovieReview
import com.example.moviereviews.movie_reviews.domain.repository.MovieReviewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieReviewsRepositoryImpl @Inject constructor(
    private val api: MovieReviewsApi
) : MovieReviewsRepository {

    override suspend fun getMovieReviews(): Flow<PagingData<MovieReview>> = Pager(
        PagingConfig(pageSize = 10, prefetchDistance = 2),
        pagingSourceFactory = { MoviesPagingSource(api) }
    ).flow
}