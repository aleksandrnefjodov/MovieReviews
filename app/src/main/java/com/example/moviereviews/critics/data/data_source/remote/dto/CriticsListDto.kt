package com.example.moviereviews.critics.data.data_source.remote.dto

data class CriticsListDto(
    val copyright: String,
    val num_results: Int,
    val results: List<CriticDto>,
    val status: String
)