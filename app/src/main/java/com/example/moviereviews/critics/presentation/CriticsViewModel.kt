package com.example.moviereviews.critics.presentation

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.moviereviews.core.BaseViewModel
import com.example.moviereviews.critics.domain.model.Critic
import com.example.moviereviews.critics.domain.repository.CriticsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CriticsViewModel @Inject constructor(
    private val criticsRepository: CriticsRepository
) : BaseViewModel() {
    private lateinit var _criticsFlow: Flow<PagingData<Critic>>

    val criticsFlow: Flow<PagingData<Critic>>
        get() = _criticsFlow

    init {
        getAllCritics()
    }

    private fun getAllCritics() = launchPagingAsync({
        criticsRepository.getAllCritics().cachedIn(viewModelScope)
    }, {
        _criticsFlow = it
    })


}