package com.caxstudio.challengeandroid.data.repository

import com.caxstudio.challengeandroid.data.ApiService
import com.caxstudio.challengeandroid.data.model.character.Result
import com.caxstudio.challengeandroid.utils.UiProgress
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
    private val apiServiceDataSource: ApiService
) : CharacterRepository {
    override suspend fun getCharacters(result: (UiProgress<List<Result>>) -> Unit) {
        val characters = apiServiceDataSource.getCharacters(1).results
        result.invoke(
            UiProgress.Success(characters)
        )
    }
}