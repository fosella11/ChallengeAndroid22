package com.caxstudio.challengeandroid.data.di

import arrow.retrofit.adapter.either.EitherCallAdapterFactory
import com.caxstudio.challengeandroid.data.ApiEndPoint
import com.caxstudio.challengeandroid.data.Repository
import com.caxstudio.challengeandroid.domain.IRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// These modules are used to provide instances of necessary objects throughout the application using Dagger Hilt,
// a dependency injection library for Android. The @InstallIn annotation indicates which Hilt component to install
// the modules in, in this case the SingletonComponent. DataModule provides instances of objects needed for API
// communication, while RepositoryModule provides instances of objects needed for data storage and retrieval.

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    // Provides an instance of HttpLoggingInterceptor for logging HTTP requests and responses
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    // Provides an instance of OkHttpClient with the logging interceptor
    @Provides
    @Singleton
    fun provideHttpClient(interceptor: Interceptor) =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    // Provides an instance of Retrofit with the base URL of the API, the OkHttpClient, an EitherCallAdapterFactory, and a GsonConverterFactory
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(okHttpClient)
            .addCallAdapterFactory(EitherCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provides an instance of the API endpoint using the Retrofit instance
    @Provides
    @Singleton
    fun provideEndPoint(retrofit: Retrofit): ApiEndPoint {
        return retrofit.create(ApiEndPoint::class.java)
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    // Binds the implementation of the IRepository interface to the Repository class
    @Singleton
    @Binds
    abstract fun provideRepository(impl: Repository): IRepository
}