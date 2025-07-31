package com.cessup.cacao_mobile_android.platform.ui.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.platform.utils.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val repository: UserRepositoryImpl,
    private val router: Router
) : ViewModel() {

    private val _authResult = MutableStateFlow<Result<String>?>(null)
    val authResult: StateFlow<Result<String>?> = _authResult


    fun access(email: String, password: String) {
        viewModelScope.launch {
            repository.authenticate(email, password).collect { result ->
                _authResult.value = result
            }
        }
    }

    fun loginAction() {
        router.navigateToHome()
    }

    fun registerAction() {
        router.navigateToSignUp()
    }

    fun forgotPasswordAction() {
        router.navigateToForgot()
    }
}