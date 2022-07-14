package com.caxstudio.challengeandroid.data.model

data class Episodes(
    val info: Info,
    val results: List<Episode> = emptyList()
)