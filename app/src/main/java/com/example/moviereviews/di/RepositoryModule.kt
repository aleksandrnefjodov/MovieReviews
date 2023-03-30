package com.example.moviereviews.di

import com.example.moviereviews.critics.data.repository.CriticsRepositoryImpl
import com.example.moviereviews.critics.domain.repository.CriticsRepository
import com.example.moviereviews.movie_reviews.data.repository.MovieReviewsRepositoryImpl
import com.example.moviereviews.movie_reviews.domain.repository.MovieReviewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMovieReviewsRepository(
        movieReviewsRepositoryImpl: MovieReviewsRepositoryImpl
    ): MovieReviewsRepository

    @Binds
    abstract fun bindCriticsRepository(
        criticsRepositoryImpl: CriticsRepositoryImpl
    ): CriticsRepository
}