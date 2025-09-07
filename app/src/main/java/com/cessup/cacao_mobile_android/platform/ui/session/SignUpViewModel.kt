package com.cessup.cacao_mobile_android.platform.ui.session

import androidx.lifecycle.ViewModel
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: UserRepositoryImpl
) : ViewModel() {

    suspend fun signUp(email:String, passowrd: String) {
        val result = repository.authenticate(email,passowrd)

        result.collect { id ->
        }
    }
}