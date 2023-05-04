package com.caxstudio.challengeandroid.data.dto

typealias CharactersDto = ResponseListDto<CharacterDto>

data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    inner class Location(
        val name: String,
        val url: String
    )
}