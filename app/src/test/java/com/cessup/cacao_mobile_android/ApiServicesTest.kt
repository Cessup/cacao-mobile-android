package com.cessup.cacao_mobile_android

import com.cessup.cacao_mobile_android.data.entities.UserEntity
import com.cessup.cacao_mobile_android.data.source.remote.ApiService
import com.cessup.cacao_mobile_android.data.source.remote.SignInRequest
import com.cessup.cacao_mobile_android.data.source.remote.SignInResponse
import com.cessup.cacao_mobile_android.data.source.remote.SignUpRequest
import com.cessup.cacao_mobile_android.data.source.remote.SignUpResponse
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServicesTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiServices: ApiService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/")) // use mock server URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiServices = retrofit.create(ApiService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `signInServices returns expected token`() = runBlocking {
        // Given
        val tokenString = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJrdG9yQXVkaWVuY2UiLCJpc3MiOiJrdG9yLmlvIiwidXNlcm5hbWUiOiI2ODgwMGM1YWM4ZDAzYjE1NTAwNjc5MjMiLCJleHAiOjE3NTMzOTAwMTN9.AUzOAKF6BajYsL9LTVyvXA-g_2rL5tOre_afa5YcNdI"

        val responseSingIn = SignInResponse(tokenString)
        val requestSingIn = SignInRequest("cessupx@gmail.com","pass1234")

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody("{\"token\":\"$tokenString\"}")
        )

        // When
        val response = apiServices.signInService(requestSingIn)

        // Then
        assertTrue(response.isSuccessful)
        val token = response.body()
        assertNotNull(token)
        assertEquals(responseSingIn, token)
    }

    @Test
    fun `signUpServices returns expected id`() = runBlocking {
        // Given
        val idString = "6882bffbcc34f069b37d76f1"

        val responseSingUp = SignUpResponse(idString)
        val requestSingUp = SignUpRequest("mobile1@gmail.com","pass1234")

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody("{\"id\":\"$idString\"}")
        )

        // When
        val response = apiServices.signUpService(requestSingUp)

        // Then
        assertTrue(response.isSuccessful)
        val id = response.body()
        assertNotNull(id)
    }

    @Test
    fun `meServices returns expected user`() = runBlocking {
        // Given
        val jsonString = "{}"
        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJrdG9yQXVkaWVuY2UiLCJpc3MiOiJrdG9yLmlvIiwidXNlcm5hbWUiOiI2ODgwMGM1YWM4ZDAzYjE1NTAwNjc5MjMiLCJleHAiOjE3NTM0MDQ2MTN9.naegfkiEeYDeMXUTVy-suvpCLg-eJDEBsi4AsR0iChs"
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody("{\"id\":\"0\",\"email\":\"mobile@gmail.com\",\"password\":\"pass123\"}")
        )

        // When
        val response = apiServices.meService(token)
        val userRequest = UserEntity(0,"mobile@gmail.com","pass123")

        // Then
        assertTrue(response.isSuccessful)
        val result = response.body()
        assertNotNull(result)
        assertEquals(userRequest, result)
    }
}