package com.caxstudio.challengeandroid.utils

import androidx.lifecycle.MutableLiveData
import com.caxstudio.challengeandroid.data.model.dto.ResultDTO
import com.caxstudio.challengeandroid.data.repository.CharacterRepository
import dagger.Provides
import javax.inject.Singleton

class FakeRepositoryModule {

    @Provides
    @Singleton
    fun characterRepository(): CharacterRepository =
        object : CharacterRepository {

            private val characters = MutableLiveData<List<ResultDTO>>(listOf());


            override suspend fun getCharacters(result: (UiProgress<List<ResultDTO>>) -> Unit) {
            }
        }
}