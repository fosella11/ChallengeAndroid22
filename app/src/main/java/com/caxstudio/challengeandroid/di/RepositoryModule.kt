package com.caxstudio.challengeandroid.di

import com.caxstudio.challengeandroid.data.repository.AuthRepository
import com.caxstudio.challengeandroid.data.repository.AuthRepositoryImp
import com.caxstudio.challengeandroid.data.repository.CharacterRepository
import com.caxstudio.challengeandroid.data.repository.CharacterRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * DataSource with Hilt
 * SingletonComponent (Injected for Application)
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // Regresamos una implementacion que puede ser lo que queramos
    // pero del tipo EpisodesRepository (Inversion de dependencia)
    @Binds
    @Singleton
    abstract fun charactersRepository(repositoryImp: CharacterRepositoryImp): CharacterRepository

    // Regresamos una implementacion que puede ser lo que queramos
    // pero del tipo EpisodesRepository (Inversion de dependencia)
    @Binds
    @Singleton
    abstract fun authRepository(authRepositoryImp: AuthRepositoryImp): AuthRepository
}