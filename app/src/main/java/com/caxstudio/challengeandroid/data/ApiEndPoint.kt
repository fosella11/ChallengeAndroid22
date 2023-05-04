package com.caxstudio.challengeandroid.data

import arrow.core.Either
import arrow.retrofit.adapter.either.networkhandling.CallError
import com.caxstudio.challengeandroid.data.dto.CharacterDto
import com.caxstudio.challengeandroid.data.dto.CharactersDto
import com.caxstudio.challengeandroid.data.dto.EpisodeDto
import com.caxstudio.challengeandroid.data.dto.LocationDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndPoint {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("gender") gender: String?,
        @Query("status") status: String?
    ): Either<CallError, CharactersDto>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Either<CallError, CharacterDto>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Either<CallError, LocationDto>

    @GET("episode/{ids}")
    suspend fun getEpisode(@Path("ids") id: String): Either<CallError, List<EpisodeDto>>
}