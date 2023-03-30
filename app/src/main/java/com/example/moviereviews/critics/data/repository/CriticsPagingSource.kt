package com.example.moviereviews.critics.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviereviews.critics.data.data_source.mappers.toCritic
import com.example.moviereviews.critics.data.data_source.remote.CriticsApi
import com.example.moviereviews.critics.domain.model.Critic
import retrofit2.HttpException
import java.io.IOException

class CriticsPagingSource(
    private val api: CriticsApi
) : PagingSource<Int, Critic>() {
    override fun getRefreshKey(state: PagingState<Int, Critic>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Critic> {

        val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
        val offset = (pageNumber - 1) * 20
        val pageSize = params.loadSize

        return try {
            val critics = api.getCriticsList(offset, pageNumber, pageSize)
                .results.map { it.toCritic() }

            LoadResult.Page(
                data = critics,
                prevKey = if (pageNumber == INITIAL_PAGE_NUMBER) null else pageNumber - 1,
                nextKey = if (critics.isEmpty()) null else pageNumber + 1
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