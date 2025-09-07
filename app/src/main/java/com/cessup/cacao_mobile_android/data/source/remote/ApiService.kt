package com.cessup.cacao_mobile_android.data.source.remote

import com.cessup.cacao_mobile_android.data.entities.UserEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * ApiService is an interface about services from server.
 *
 * There are function to communicate with the server
 *
 * @author
 *     Cessup
 * @since 1.0
 */
interface ApiService {
    /**
     * This function authenticate a user in the system.
     *
     * @property request the AuthenticateRequest have email and password to authenticated
     * @return [TokenResponse] that is the token for the session
     */
    @POST("/session/authenticate")
    suspend fun authenticateService(
        @Body request: AuthenticateRequest
    ): Response<TokenResponse>

    /**
     * This function register a new user in the system.
     *
     * @property request the RegisterRequest have all information about the new user
     * @return [TokenResponse] that is the token for the session
     */
    @POST("/session/register")
    suspend fun registerService(
        @Body request: RegisterUserRequest
    ): Response<TokenResponse>

    /**
     * This function profile give the user authenticated in the system.
     *
     * @property token the token is for the session
     * @return [UserEntity] the result is a User from the server so there are all information about it.
     */
    @GET("/session/profile")
    suspend fun profileService(
        @Header("Authorization") token: String
    ): Response<UserEntity>

    /**
     * This function profile give the user authenticated in the system.
     *
     * @property token the token is for the session
     * @property userDetailsId the id is from user details.
     *
     * @return [Response<String>] is a message about the result
     */
    @PUT("/session/{id}/userDetails")
    suspend fun setUserDetailsService(
        @Header("Authorization") token: String,
        @Path("id") userDetailsId: String
    ): Response<String>

    /**
     * This function reset password from user.
     *
     * @property token unique identifier about session from server.
     *
     * @return [Response<String>] is a message about the result
     */
    @PUT("/session/resetPassword")
    suspend fun resetPasswordService(
        @Header("Authorization") token: String
    ): Response<String>

    /**
     * This function delete user account in the system.
     *
     * @property token unique identifier about session from server.
     *
     * @return [Response<String>] is a message about the result
     */
    @GET("/session/deleteAccount")
    suspend fun deleteAccountService(
        @Header("Authorization") token: String
    ): Response<String>

    /**
     * This function save a user in the user table.
     *
     * @property token unique identifier about session from server.
     *
     * @return [Response<String>] is a message about the result
     */
    @GET("/session/closeSession")
    suspend fun closeSessionService(
        @Header("Authorization") token: String
    ): Response<String>
}

/**
 * Request to Register a new user
 *
 * @property email the email the user belongs to
 * @property phone the phone of the user for account
 * @property password the password of the user for account
 * @property nickname All information about this user
 */
data class RegisterUserRequest(val email: String, val phone: String, val password: String, val nickname:String, val details:RegisterUserDetailsRequest)

/**
 * Request to Register Details of a new user
 *
 * @property name All information about this user
 * @property lastName All information about this user
 * @property address All information about this user
 * @property gender All information about this user
 * @property birthdate All information about this user
 */
data class RegisterUserDetailsRequest(val name:String, val lastName:String,val address: String, val gender:String, val birthdate:Long)

/**
 * Request to Register Details of a new user
 *
 * @property email All information about this user
 * @property password All information about this user
 */
data class AuthenticateRequest(val email: String, val password: String)

/**
 * Request to Register Details of a new user
 *
 * @property token unique identifier about session from server.
 */
data class TokenResponse(val token: String)