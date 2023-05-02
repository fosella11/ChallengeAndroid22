package com.caxstudio.challengeandroid.data

import arrow.core.Either
import arrow.core.Option
import arrow.core.flatMap
import com.caxstudio.challengeandroid.data.mapper.*
import com.caxstudio.challengeandroid.domain.IRepository
import com.caxstudio.challengeandroid.domain.error.CharacterError
import com.caxstudio.challengeandroid.domain.model.Character
import com.caxstudio.challengeandroid.domain.model.CharacterDetails
import com.caxstudio.challengeandroid.domain.model.CharacterFilter
import com.caxstudio.challengeandroid.domain.model.Episode
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiEndPoint) : IRepository {

    // Retrieve a list of characters, optionally filtered by gender
    override suspend fun getCharacters(gender: Option<CharacterFilter>): Either<CharacterError, List<Character>> {

        // Extract the gender filter value from the Option, or null if it doesn't exist
        val genderApi = gender.orNull()?.value

        // Call the API to retrieve the first page of characters
        return api.getCharacters(1, genderApi, "").flatMap { page1 ->

            // If there is no "next" page, return the results from the first page
            if (page1.info.next == null) return@flatMap Either.Right(page1.results)

            // Otherwise, call the API to retrieve the second page and combine the results
            api.getCharacters(2, genderApi, "").flatMap { page2 ->
                Either.Right(page1.results + page2.results)
            }
        }
            // Convert the API response to domain objects and handle any errors
            .map { it.toCharactersDomain() }
            .mapLeft { it.toErrorDomain() }
    }

    // Retrieve details for a single character
    override suspend fun getCharacterDetails(id: Int): Either<CharacterError, CharacterDetails> {

        // Call the API to retrieve the character details and convert the response to a domain object
        return api.getCharacterDetails(id)
            .map { it.toCharacterDetailsDomain() }
            .mapLeft { it.toErrorDomain() }
    }

    // Retrieve the location of a single character
    override suspend fun getLocation(id: Int): Either<CharacterError, String> {

        // Call the API to retrieve the location and convert the response to a domain object
        return api.getLocation(id)
            .map { it.toLocationDomain() }
            .mapLeft { it.toErrorDomain() }
    }

    // Retrieve details for a list of episodes
    override suspend fun getEpisodes(ids: List<Int>): Either<CharacterError, List<Episode>> {

        // Call the API to retrieve the episodes and convert the response to domain objects
        return api.getEpisode(ids.joinToString(separator = ","))
            .map { it.toEpisodeDomain() }
            .mapLeft { it.toErrorDomain() }
    }
}