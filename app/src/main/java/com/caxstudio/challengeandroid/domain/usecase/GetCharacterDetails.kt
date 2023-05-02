package com.caxstudio.challengeandroid.domain.usecase

import arrow.core.Either
import arrow.core.continuations.either
import com.caxstudio.challengeandroid.domain.IRepository
import com.caxstudio.challengeandroid.domain.error.CharacterError
import com.caxstudio.challengeandroid.domain.model.CharacterDetailsExtended
import javax.inject.Inject

class GetCharacterDetails @Inject constructor(private val repository: IRepository) :
    UseCase<GetCharacterDetails.Params, CharacterDetailsExtended, CharacterError>() {

    // This function will be called when the use case is invoked
    override suspend fun run(params: Params): Either<CharacterError, CharacterDetailsExtended> {
        return either {
            // Get the character details from the repository and bind it to a value
            val details = repository.getCharacterDetails(params.id).bind()
            // Get the location name from the repository for the character's location ID and bind it to a value
            val location = repository.getLocation(details.locationId).bind()
            // Get the episode details from the repository for the character's episode ID list and bind it to a value
            val episodes = repository.getEpisodes(details.episodesIdList).bind()
            // Create a new CharacterDetailsExtended object with the retrieved information and return it
            CharacterDetailsExtended(details.character, location, episodes)
        }
    }

    // Data class for the input parameters of the use case
    data class Params(val id: Int)
}