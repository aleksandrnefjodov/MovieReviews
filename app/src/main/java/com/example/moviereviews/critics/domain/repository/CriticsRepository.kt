package com.example.moviereviews.critics.domain.repository

import androidx.paging.PagingData
import com.example.moviereviews.critics.domain.model.Critic
import kotlinx.coroutines.flow.Flow

interface CriticsRepository {
    suspend fun getAllCritics(): Flow<PagingData<Critic>>
}