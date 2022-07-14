package com.caxstudio.challengeandroid.data

import com.caxstudio.challengeandroid.data.model.Episode
import com.caxstudio.challengeandroid.data.model.Episodes
import com.caxstudio.challengeandroid.utils.EPISODES_URL_PATH
import retrofit2.http.GET

interface ApiService {
    @GET(EPISODES_URL_PATH)
    suspend fun getEpisodes(): Episodes

    @GET("?algo")
    suspend fun getEpisode(): Episode
}