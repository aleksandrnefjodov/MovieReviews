package com.example.moviereviews.movie_reviews.data.data_source.remote

import com.example.moviereviews.BuildConfig
import com.example.moviereviews.movie_reviews.data.data_source.remote.dto.MoviesListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieReviewsApi {
    @GET("/svc/movies/v2/reviews/all.json")
    suspend fun getReviewsList(
        @Query("offset") offset: Int,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int,
        @Query(value = "api-key") apiKey: String = BuildConfig.API_KEY
    ): MoviesListDto

    companion object {
        const val BASE_URL = "https://api.nytimes.com/"
    }
}