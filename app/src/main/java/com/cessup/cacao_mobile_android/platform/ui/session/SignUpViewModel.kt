package com.cessup.cacao_mobile_android.platform.ui.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.domain.model.User
import com.cessup.cacao_mobile_android.domain.model.UserDetails
import com.cessup.cacao_mobile_android.platform.utils.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val repository: UserRepositoryImpl,
    private val router: Router
) : ViewModel() {

    private val _registerResult = MutableStateFlow<Result<String>?>(null)
    val authResult: StateFlow<Result<String>?> = _registerResult

     fun signUp(email:String, phone:String, password: String, nickName: String, name:String, lastName: String, address:String, gender:String, birthdate: Long) {
        viewModelScope.launch {
            val userDetail = UserDetails("",name,lastName,address,gender,birthdate)
            val user = User("",email,phone,nickName,password,userDetail)
            repository.insertUser(user).collect { result ->
                _registerResult.value = result as Result<String>?

                if (result.isSuccess){
                    router.navigateToHome()
                }
            }
        }
    }
}