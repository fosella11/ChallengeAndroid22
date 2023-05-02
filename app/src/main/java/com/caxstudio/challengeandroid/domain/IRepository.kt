package com.caxstudio.challengeandroid.domain

import arrow.core.Either
import arrow.core.None
import arrow.core.Option
import com.caxstudio.challengeandroid.domain.error.CharacterError
import com.caxstudio.challengeandroid.domain.model.Character
import com.caxstudio.challengeandroid.domain.model.CharacterDetails
import com.caxstudio.challengeandroid.domain.model.CharacterFilter
import com.caxstudio.challengeandroid.domain.model.Episode

interface IRepository {

    // Method to get a list of characters based on their gender.
    // `gender` parameter is optional, and allows filtering by gender.
    suspend fun getCharacters(
        gender: Option<CharacterFilter> = None
    ): Either<CharacterError, List<Character>>

    // Method to get the details of a specific character based on their `id`.
    suspend fun getCharacterDetails(id: Int): Either<CharacterError, CharacterDetails>

    // Method to get the location of a specific character based on their `id`.
    suspend fun getLocation(id: Int): Either<CharacterError, String>

    // Method to get a list of episodes based on their `ids`.
    suspend fun getEpisodes(ids: List<Int>): Either<CharacterError, List<Episode>>
}