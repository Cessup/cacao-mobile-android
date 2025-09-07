package com.cessup.cacao_mobile_android.platform.ui.session

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: UserRepositoryImpl
) : ViewModel() {

    private val _token = MutableStateFlow("")
    val token: StateFlow<String> = _token

    private val _name = MutableLiveData<String>("Alice")
    val name: LiveData<String> = _name

     fun signInAction(email:String, keyword: String) {

         viewModelScope.launch {
             val result = repository.signIn(email,keyword)

             result.collect { token ->
                 _token.value = token
             }
         }
    }
}