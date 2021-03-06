package com.caxstudio.challengeandroid.data

import com.caxstudio.challengeandroid.data.model.character.Characters
import com.caxstudio.challengeandroid.utils.ConstantsApp
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ConstantsApp.CHARACTERS_URL_PATH)
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("name") name: String? = null
    ): Characters
}