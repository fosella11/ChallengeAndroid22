package com.caxstudio.challengeandroid.di

import com.caxstudio.challengeandroid.BuildConfig
import com.caxstudio.challengeandroid.data.ApiService
import com.caxstudio.challengeandroid.utils.ConstantsApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * DataSource with Hilt
 * SingletonComponent (Injected for Application)
 */
@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    @Named("BaseURL")
    fun provideApiServiceBaseUrl() = ConstantsApp.URL_BASE

    private fun okHttpClient(): OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(10, TimeUnit.SECONDS)
        okHttpClient.readTimeout(30, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(30, TimeUnit.SECONDS)

        when {
            BuildConfig.DEBUG -> {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                okHttpClient.addInterceptor(logging)
            }
        }

        return okHttpClient
    }

    @Singleton
    @Provides
    fun providesAPIService(@Named("BaseURL") baseURL: String): Retrofit {
        val httpClient = okHttpClient()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .client(httpClient.build())
            .build()
    }

    @Singleton
    @Provides
    fun restAPIServiceDataSource(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

}