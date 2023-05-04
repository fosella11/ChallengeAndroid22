package com.caxstudio.challengeandroid.data.dto

import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("air_date")
    val releaseDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)