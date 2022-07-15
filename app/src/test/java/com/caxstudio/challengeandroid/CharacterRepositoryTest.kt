package com.caxstudio.challengeandroid

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.caxstudio.challengeandroid.data.ApiService
import com.caxstudio.challengeandroid.data.model.character.Result
import com.caxstudio.challengeandroid.data.repository.CharacterRepositoryImp
import com.caxstudio.challengeandroid.utils.UiProgress
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets

class CharacterRepositoryTest {

    @Test
    fun testSuccessfulResponse() {
        mockWebServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse().apply { addResponse("api_characters.json") }
            }
        }
    }

    private val mockWebServer = MockWebServer().apply {
        url("/")
    }

    //Creamos instancia de dataSource
    private val dataSourceModule = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    //Todas las tareas suspend (Background) se ejecutan al arrancar
    @get:Rule
    val rule = InstantTaskExecutorRule()

    //Apagar server al finalizar
    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Get character from Api Success`() {
        mockWebServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse().apply { addResponse("api_characters.json") }
            }
        }
        runBlocking {
            var results: List<Result> = emptyList()
            characterRepository.getCharacters { progress ->
                results = when (progress) {
                    is UiProgress.Success -> progress.data
                    is UiProgress.Loading -> emptyList()
                    is UiProgress.Failure -> progress.data
                }
            }
            assertEquals(20, results.size)
        }

    }

    //Creamos insta del Repository
    private val characterRepository = CharacterRepositoryImp(dataSourceModule)
}

/**
 * Read file and return fake request
 *
 * @param filePath with fake data response.
 */
fun MockResponse.addResponse(filePath: String): MockResponse {
    val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
    val source = inputStream?.source()?.buffer()
    source?.let {
        setResponseCode(200)
        setBody(it.readString(StandardCharsets.UTF_8))
    }
    return this
}