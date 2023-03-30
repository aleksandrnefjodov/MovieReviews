package com.example.moviereviews.movie_reviews.presentation

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.moviereviews.core.BaseViewModel
import com.example.moviereviews.movie_reviews.domain.model.MovieReview
import com.example.moviereviews.movie_reviews.domain.repository.MovieReviewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ReviewsViewModel @Inject constructor(
    private val repository: MovieReviewsRepository
) : BaseViewModel() {

    private lateinit var _moviesPreviewsFlow: Flow<PagingData<MovieReview>>
    val moviesPreviewsFlow: Flow<PagingData<MovieReview>>
        get() = _moviesPreviewsFlow

    init {
        getMovieReviews()
    }

    private fun getMovieReviews() = launchPagingAsync({
        repository.getMovieReviews().cachedIn(viewModelScope)
    }, {
        _moviesPreviewsFlow = it
    })
}