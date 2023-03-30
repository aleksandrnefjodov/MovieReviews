package com.example.moviereviews.critics.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Critic(
    val bio: String,
    val display_name: String,
    val seo_name: String,
    val sort_name: String,
    val status: String,
    val credit: String?,
    val height: Int?,
    val src: String?,
    val type: String?,
    val width: Int?,
) : Parcelable
