package com.cessup.cacao_mobile_android.platform.ui.session

import androidx.lifecycle.ViewModel
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.platform.utils.Router
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val repository: UserRepositoryImpl,
    private val router: Router
) : ViewModel() {

    suspend fun signUp(email:String, passowrd: String) {

    }
}