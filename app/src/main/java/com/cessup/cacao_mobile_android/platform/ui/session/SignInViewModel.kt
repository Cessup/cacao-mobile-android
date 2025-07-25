package com.cessup.cacao_mobile_android.platform.ui.session

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.platform.utils.Router
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val repository: UserRepositoryImpl,
    private val router: Router
) : ViewModel() {

    suspend fun signInAction(email:String, keyword: String) {
        val result = repository.signIn(email,keyword)

        result.collect { token ->
            if(token.isNotEmpty()){
                Log.i("SIGN_IN_ACTION", token)
                router.navigateToHome(token)
            }else{
                Log.i("SIGN_IN_ACTION", token)
                router.navigateToHome("token")
            }
        }
    }

    fun signUpAction() {
        router.navigateToSignUp()
    }

    fun forgotAction() {
        router.navigateToForgot()
    }

}