package com.caxstudio.challengeandroid.domain.model

data class CharacterDetails(
    val character: Character,
    val locationId: Int,
    val episodesIdList: List<Int>
)

data class CharacterDetailsExtended(
    val character: Character,
    val location: String,
    val episodes: List<Episode>
)