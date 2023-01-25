package com.realityexpander.cleanarchitecturenoteapp.network

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ImageApiServiceTest {
    private lateinit var service: ImageApiService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url("")) //We will use MockWebServers url
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageApiService::class.java)
    }

    private fun enqueueMockResponse(
        fileName: String,
        headers: Map<String, String> = emptyMap(),
        status: String = "HTTP/1.1 200 OK",
        statusCode: Int = 200
    ) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()

            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8)) // will be errorBody for codes >=300
            mockResponse.setStatus(status)
            mockResponse.setResponseCode(statusCode)
            server.enqueue(mockResponse)
        }
    }

    @Test
    fun getSearchedResult_sentRequest_receivedExpected() {
        runBlocking {
            // Prepare fake response
            enqueueMockResponse("ImageResponse.json")

            //Send Request to the MockServer
            val responseBody = service.getSearchedImage("nature", 5).body()

            //Request received by the mock server
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v1/search?query=nature&per_page=5")
        }
    }

    @Test
    fun getSearchedResult_receivedResponse_wrongPageSize_shouldFail() {
        runBlocking {
            enqueueMockResponse(
                "ErrorResponse.json",
                status = "HTTP/1.1 400 Bad Request",
                statusCode = 400
            )

            val response = service.getSearchedImage("nature", 6)
            assertThat(response.code()).isEqualTo(400)

            val photoList = response.body()
            assertThat(photoList).isNull()

        }
    }

    @Test
    fun getSearchedResult_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("ImageResponse.json")

            val responseBody = service.getSearchedImage("nature", 5).body()
            val photoList = responseBody!!.photos
            val photo = photoList[0]

            assertThat(photo.id).isEqualTo(572897)
            assertThat(photo.photographer).isEqualTo("eberhard grossgasteiger")
            assertThat(photo.photographer_url).isEqualTo("https://www.pexels.com/@eberhardgross")
        }
    }

    @Test
    fun getSearchedResult_path_correctForm() {
        runBlocking {
            enqueueMockResponse("ImageResponse.json")

          service.getSearchedImage("nature", 5).body()
            val request = runCatching {
                server.takeRequest(timeout = 5, unit = TimeUnit.SECONDS)
            }.getOrNull()

            assertThat(request?.path).isEqualTo("/v1/search?query=nature&per_page=5")
        }
    }


    @After
    fun tearDown() {
        server.shutdown()
    }
}