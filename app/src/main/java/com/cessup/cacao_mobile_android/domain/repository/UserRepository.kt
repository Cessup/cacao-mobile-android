package com.cessup.cacao_mobile_android.domain.repository

import com.cessup.cacao_mobile_android.domain.model.User
import com.cessup.cacao_mobile_android.domain.model.UserDetails
import kotlinx.coroutines.flow.Flow

/**
 * User Repository have every data about the users.
 *
 * This class is a interface with all functions about user information
 * There are actions that the user can perform
 *
 * @author
 *     Cessup
 * @since 1.0
 */
interface UserRepository {

    /**
     * This function insert a new user in the database
     *
     * @param email the user information from the services is here
     * @param password the user information from the services is here
     *
     * @return a user
     */
    suspend fun authenticate(email:String, password: String): Flow<Result<String>>

    /**
     * This function insert a new user in the database
     *
     * @param user the user information from the services is here
     * @return a user
     */
    suspend fun insertUser(user: User): Flow<Result<Any>>

    /**
     * This function return information about user
     *
     * @param id the user information from the services is here
     * @return a user
     */
    suspend fun getUser(id: String): Flow<Result<Any>>

    /**
     * The system can update the user details data to the user
     *
     * @param userDetails the email is a filter to search the user in database
     * @return a Boolean
     */
    suspend fun updateUserDetails(userDetails: UserDetails): Flow<Result<Any>>

    /**
     * This function update a user in the database
     *
     * @param email the id is identification to search the object in database
     * @param password the password is the new value to change it
     * @return a user
     */
    suspend fun updatePassword(email: String, password:String): Flow<Result<Any>>
    /**
     * This function delete a user in the database
     *
     * @param id the id is identification to search the object in database
     * @return a Boolean
     */
    suspend fun deleteUser(id: String) : Flow<Result<Any>>
}