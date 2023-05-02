package com.caxstudio.challengeandroid.domain.usecase

import arrow.core.Either
import arrow.core.Option
import com.caxstudio.challengeandroid.domain.IRepository
import com.caxstudio.challengeandroid.domain.error.CharacterError
import com.caxstudio.challengeandroid.domain.model.Character
import com.caxstudio.challengeandroid.domain.model.Gender
import javax.inject.Inject

// Define a class that gets filtered characters from the repository
class GetFilteredCharacters @Inject constructor(private val repository: IRepository) :
    UseCase<GetFilteredCharacters.Params, List<Character>, CharacterError>() {

    // Override the `run` method defined in the `UseCase` abstract class to get filtered characters from the repository
    override suspend fun run(params: Params): Either<CharacterError, List<Character>> {
        // Get the `Gender` option from the `Params` object, using the `Option` utility class
        val gender = Option.fromNullable(params.gender)

        // Call the `getCharacters` method of the repository, passing the `Gender` option as a parameter,
        // and return the result as an `Either` type
        return repository.getCharacters(gender)
    }

    // Define a data class to hold the input parameters for this use case
    data class Params(val gender: Gender)
}