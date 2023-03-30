package com.example.moviereviews.critics.data.data_source.mappers

import com.example.moviereviews.critics.data.data_source.remote.dto.CriticDto
import com.example.moviereviews.critics.domain.model.Critic

fun CriticDto.toCritic(): Critic {
    return Critic(
        bio = bio,
        display_name = display_name,
        seo_name = seo_name,
        sort_name = sort_name,
        status = status,
        credit = multimedia?.resource?.credit,
        height = multimedia?.resource?.height,
        src = multimedia?.resource?.src,
        type = multimedia?.resource?.type,
        width = multimedia?.resource?.width
    )
}