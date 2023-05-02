package com.caxstudio.challengeandroid.data.mapper

import arrow.retrofit.adapter.either.networkhandling.CallError
import com.caxstudio.challengeandroid.data.dto.CharacterDto
import com.caxstudio.challengeandroid.data.dto.EpisodeDto
import com.caxstudio.challengeandroid.data.dto.LocationDto
import com.caxstudio.challengeandroid.domain.error.CharacterError
import com.caxstudio.challengeandroid.domain.model.*


fun CallError.toErrorDomain(): CharacterError = CharacterError.UnknownError

fun List<CharacterDto>.toCharactersDomain() = this.map { it.toCharacterDomain() }

fun CharacterDto.toCharacterDomain() =
    Character(id, name, image, Status.getStatus(status), Gender.getGender(gender))

fun CharacterDto.toCharacterDetailsDomain(): CharacterDetails {
    val character = this.toCharacterDomain()
    val location = location.url.split('/').last().toInt()
    val episodes = episode.map { it.split('/').last().toInt() }
    return CharacterDetails(character, location, episodes)
}

fun LocationDto.toLocationDomain() = this.name

fun List<EpisodeDto>.toEpisodeDomain() = this.map { Episode(it.episode, it.name, it.releaseDate) }