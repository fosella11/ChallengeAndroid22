package com.caxstudio.challengeandroid.data.repository

import com.caxstudio.challengeandroid.data.model.character.Result
import com.caxstudio.challengeandroid.utils.UiProgress

interface CharacterRepository {
    suspend fun getCharacters(result: (UiProgress<List<Result>>) -> Unit)
}

