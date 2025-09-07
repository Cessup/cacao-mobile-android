package com.cessup.cacao_mobile_android.data

import com.cessup.cacao_mobile_android.data.source.local.db.user.UserDao
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserEntity
import com.cessup.cacao_mobile_android.data.source.remote.SignInRequest
import com.cessup.cacao_mobile_android.data.source.remote.SignUpRequest
import com.cessup.cacao_mobile_android.data.source.remote.UserService
import com.cessup.cacao_mobile_android.domain.model.User
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val api: UserService
) : UserRepository{

    override suspend fun insert(user: User) = userDao.insert(UserEntity(0,user.username))

    override fun getAllUser(): Flow<List<User>> = userDao.getAllUsers().map {listUserEntity ->
        listUserEntity.map {
                item -> User(username = item.username)
        }
    }

    override suspend fun signUp(email: String, keyword: String): Flow<String> {

        val result = api.signUpService(SignUpRequest(email, keyword))
        return flowOf(result.body()?.id ?: "")
    }

    override suspend fun signIn(email: String, keyword: String): Flow<String> {
        val result = api.signInService(SignInRequest(email, keyword))
        return flowOf(result.body()?.token ?: "")
    }

    override suspend fun getProfile(token: String): Flow<User> {
        val user = api.meService("Bearer $token").body()
        return flowOf(User(user?.email ?: "Not username"))
    }

}