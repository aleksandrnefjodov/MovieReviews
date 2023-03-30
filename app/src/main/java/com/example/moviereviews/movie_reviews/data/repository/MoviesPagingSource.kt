package com.example.moviereviews.movie_reviews.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviereviews.movie_reviews.data.data_source.mappers.toMovieReview
import com.example.moviereviews.movie_reviews.data.data_source.remote.MovieReviewsApi
import com.example.moviereviews.movie_reviews.domain.model.MovieReview
import retrofit2.HttpException
import java.io.IOException

class MoviesPagingSource(
    private val api: MovieReviewsApi
) : PagingSource<Int, MovieReview>() {
    override fun getRefreshKey(state: PagingState<Int, MovieReview>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieReview> {

        val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
        val offset = (pageNumber - 1) * 20
        val pageSize = params.loadSize

        return try {
            val movieReviews = api.getReviewsList(offset, pageNumber, pageSize)
                .results.map { it.toMovieReview() }

            LoadResult.Page(
                data = movieReviews,
                prevKey = if (pageNumber == INITIAL_PAGE_NUMBER) null else pageNumber - 1,
                nextKey = if (movieReviews.isEmpty()) null else pageNumber + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }


    }


    companion object {
        const val INITIAL_PAGE_NUMBER = 1
    }
}