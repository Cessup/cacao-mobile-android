package com.cessup.cacao_mobile_android.data.source.remote

import com.cessup.cacao_mobile_android.data.entities.UserEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

data class SignInRequest(val email: String, val password: String)
data class SignInResponse(val token: String)

data class SignUpRequest(val email: String, val password: String)
data class SignUpResponse(val id: String)

interface UserService {
    @POST("/users/signup")
    suspend fun signInService(
        @Body request: SignInRequest
    ): Response<SignInResponse>

    @POST("/users/signin")
    suspend fun signUpService(
        @Body request: SignUpRequest
    ): Response<SignUpResponse>

    @GET("/users/me")
    suspend fun meService(
        @Header("Authorization") token: String
    ): Response<UserEntity>
}