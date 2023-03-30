package com.example.moviereviews.critics.data.data_source.remote.dto

data class CriticDto(
    val bio: String,
    val display_name: String,
    val multimedia: MultimediaDto?,
    val seo_name: String,
    val sort_name: String,
    val status: String
)