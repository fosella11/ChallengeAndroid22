package com.caxstudio.challengeandroid.data.repository

import com.caxstudio.challengeandroid.data.ApiService
import com.caxstudio.challengeandroid.data.model.Episodes
import javax.inject.Inject

interface EpisodeRepository {
    suspend fun getEpisodes(): Episodes
}

class EpisodeRepositoryImp @Inject constructor(
    private val apiServiceDataSource: ApiService
) : EpisodeRepository {
    override suspend fun getEpisodes(): Episodes {
        return apiServiceDataSource.getEpisodes()
    }
}