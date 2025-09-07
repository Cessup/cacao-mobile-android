package com.cessup.cacao_mobile_android.data

import com.cessup.cacao_mobile_android.data.exceptions.AuthenticationException
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserDao
import com.cessup.cacao_mobile_android.data.source.local.temp.LocalStorage
import com.cessup.cacao_mobile_android.data.source.remote.AuthenticateRequest
import com.cessup.cacao_mobile_android.data.source.remote.RegisterUserDetailsRequest
import com.cessup.cacao_mobile_android.data.source.remote.RegisterUserRequest
import com.cessup.cacao_mobile_android.data.source.remote.UserService
import com.cessup.cacao_mobile_android.domain.model.User
import com.cessup.cacao_mobile_android.domain.model.UserDetails
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * User Repository have every data about the users.
 *
 * This class is a interface with all functions about user information
 * There are actions that the user can perform
 *
 * @constructor Receiver a [UserDao] an object got data from data base
 * @constructor Receiver a [ApiService] an object got data from services
 *
 * @author
 *     Cessup
 * @since 1.0
 */
class UserRepositoryImpl @Inject constructor(
    private val localStorage: LocalStorage,
    private val userDao: UserDao,
    private val api: UserService
) : UserRepository{

    /**
     * This function insert a new user in the database
     *
     * @param email the user information from the services is here
     * @param password the user information from the services is here
     *
     * @return token the value is an access to the system
     */
    override suspend fun authenticate(
        email: String,
        password: String
    ): Flow<Result<String>> =
        flow {
            try {
                val response = api.authenticateService(AuthenticateRequest(email,password) )
                if(response.isSuccessful){
                    localStorage.saveToken(response.body()!!.token)
                    emit(Result.success(response.body()!!.token))
                }else{
                    emit(Result.failure(NullPointerException()))
                }
            } catch (e: Exception) {
                emit(Result.failure(e))
            }
        }


    /**
     * This function insert a new user in the database
     *
     * @param user the user information from the services is here
     * @return a user
     */
    override suspend fun insertUser(user: User): Flow<Result<Any>> =
        flow {
            try {
                val registerUserRequest = RegisterUserRequest(
                    user.email,
                    user.phone,
                    user.password,
                    user.nickName,
                    RegisterUserDetailsRequest(
                        user.details.name,
                        user.details.lastName,
                        user.details.address,
                        user.details.gender,
                        user.details.birthdate,
                    )
                )
                val response = api.registerService(registerUserRequest)
                if(response.isSuccessful){
                    localStorage.saveToken(response.body()!!.token)
                    emit(Result.success(response.body()!!.token))
                }else{
                    emit(Result.failure(NullPointerException()))
                }
            } catch (e: Exception) {
                emit(Result.failure(e))
            }
        }

    /**
     * This function return information about user
     *
     * @param id the user information from the services is here
     * @return a user
     */
    override suspend fun getUser(id: String): Flow<Result<Any>> =

    flow{
        val token = localStorage.readToken()
        val response = api.profileService("Bearer $token")
        var user : User

        try {
            if(response.isSuccessful){
                val userEntity = response.body()
                if(userEntity!=null){
                    user = User(
                        userEntity.id,
                        userEntity.email,
                        userEntity.phone,
                        userEntity.nickName,
                        userEntity.password,
                        UserDetails(
                            userEntity.details.id,
                            userEntity.details.name,
                            userEntity.details.lastName,
                            userEntity.details.address,
                            userEntity.details.gender,
                            userEntity.details.birthdate
                        )
                    )

                    emit( Result.success(user))
                }
            }else{
                emit(Result.failure(NullPointerException()))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }


    /**
     * The system can update the user details data to the user
     *
     * @param userDetails the email is a filter to search the user in database
     * @return a Boolean
     */
    override suspend fun updateUserDetails(userDetails: UserDetails): Flow<Result<Any>> =
        flow {
            try {
                val token = localStorage.readToken()
                val id = userDetails.id
                if(!token.isNullOrEmpty()){
                    val response = api.setUserDetailsService(token,id)
                    if(response.isSuccessful){
                        emit( Result.success(true))
                    }else{
                        emit(Result.failure(AuthenticationException()))
                    }
                }
            } catch (e: Exception) {
                emit(Result.failure(e))
            }
        }

    /**
     * This function update a user in the database
     *
     * @param email the id is identification to search the object in database
     * @param password the password is the new value to change it
     * @return a user
     */
    override suspend fun updatePassword(
        email: String,
        password: String
    ): Flow<Result<Any>> =
        flow {
            try {
                val token = localStorage.readToken()
                if(!token.isNullOrEmpty()){
                    val response = api.resetPasswordService(token)
                    if(response.isSuccessful){
                        emit( Result.success(true))
                    }else{
                        emit(Result.failure(AuthenticationException()))
                    }
                }

            } catch (e: Exception) {
                emit(Result.failure(e))
            }
        }

    /**
     * This function delete a user in the database
     *
     * @param id the id is identification to search the object in database
     * @return a Boolean
     */
    override suspend fun deleteUser(id: String): Flow<Result<Any>> =
    flow {
        try {
            val token = localStorage.readToken()
            if(!token.isNullOrEmpty()){
                val response = api.deleteAccountService(token)
                if(response.isSuccessful){
                    emit( Result.success(true))
                }else{
                    emit(Result.failure(AuthenticationException()))
                }
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}