package com.cessup.cacao_mobile_android.platform.ui.session

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.platform.utils.Router
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val repository: UserRepositoryImpl,
    private val router: Router
) : ViewModel() {

    suspend fun signUp(email:String, passowrd: String) {
        val result = repository.signUp(email,passowrd)

        result.collect { id ->
            Log.i("SIGN_UP_ACTION", id)
            if(id.isNotEmpty()){
                router.navigateToHome(id)
            }
        }
    }
}