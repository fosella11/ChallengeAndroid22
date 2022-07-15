package com.caxstudio.challengeandroid.data.repository

import com.caxstudio.challengeandroid.data.model.auth.User
import com.caxstudio.challengeandroid.data.model.character.Result
import com.caxstudio.challengeandroid.utils.UiProgress

interface CharacterRepository {
    suspend fun getCharacters(result: (UiProgress<List<Result>>) -> Unit)
    fun logout(result: () -> Unit)
    fun loginUser(email: String, password: String, result: (UiProgress<String>) -> Unit)
    fun saveSession(id: String, result: (User?) -> Unit)
    fun getSession(result: (User?) -> Unit)
    fun updateUserInfo(user: User, result: (UiProgress<String>) -> Unit)
    fun registerUser(
        email: String,
        password: String,
        user: User,
        result: (UiProgress<String>) -> Unit
    )
}

