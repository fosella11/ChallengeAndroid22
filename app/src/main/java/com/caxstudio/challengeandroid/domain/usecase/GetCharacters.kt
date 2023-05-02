package com.caxstudio.challengeandroid.domain.usecase

import arrow.core.Either
import com.caxstudio.challengeandroid.domain.IRepository
import com.caxstudio.challengeandroid.domain.error.CharacterError
import com.caxstudio.challengeandroid.domain.model.Character
import javax.inject.Inject

class GetCharacters @Inject constructor(private val repository: IRepository) :
    UseCase<Unit, List<Character>, CharacterError>() {

    // This function is called when the use case is executed.
    // It invokes the repository to retrieve a list of all characters.
    override suspend fun run(params: Unit): Either<CharacterError, List<Character>> {
        return repository.getCharacters()
    }
}