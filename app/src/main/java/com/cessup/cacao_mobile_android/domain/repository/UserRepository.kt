package com.cessup.cacao_mobile_android.domain.repository

import com.cessup.cacao_mobile_android.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insert(user: User)
    fun getAllUser() : Flow<List<User>>

    suspend fun signUp(email: String, keyword: String): Flow<String>

    suspend fun signIn(email: String, keyword: String): Flow<String>

    suspend fun getProfile(token: String): Flow<User>
}