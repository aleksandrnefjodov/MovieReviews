package com.example.moviereviews.critics.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.moviereviews.critics.data.data_source.remote.CriticsApi
import com.example.moviereviews.critics.domain.model.Critic
import com.example.moviereviews.critics.domain.repository.CriticsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CriticsRepositoryImpl @Inject constructor(
    private val api: CriticsApi
) : CriticsRepository {

    override suspend fun getAllCritics(): Flow<PagingData<Critic>> = Pager(
        PagingConfig(pageSize = 20, prefetchDistance = 5),
        pagingSourceFactory = { CriticsPagingSource(api) }
    ).flow
}