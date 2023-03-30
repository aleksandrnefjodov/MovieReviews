package com.example.moviereviews.critics.data.data_source.remote

import com.example.moviereviews.BuildConfig
import com.example.moviereviews.critics.data.data_source.remote.dto.CriticsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CriticsApi {
    @GET("/svc/movies/v2/critics/all.json")
    suspend fun getCriticsList(
        @Query("offset") offset: Int,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int,
        @Query(value = "api-key") apiKey: String = BuildConfig.API_KEY
    ): CriticsListDto

    companion object {
        const val BASE_URL = "https://api.nytimes.com/"
    }
}