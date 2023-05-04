package com.caxstudio.challengeandroid.data.dto

typealias LocationsDto = ResponseListDto<LocationDto>

data class LocationDto(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)