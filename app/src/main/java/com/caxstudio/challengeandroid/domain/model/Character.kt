package com.caxstudio.challengeandroid.domain.model

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val status: Status,
    val gender: Gender
)