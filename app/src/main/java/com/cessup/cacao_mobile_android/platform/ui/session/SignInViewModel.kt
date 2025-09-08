package com.cessup.cacao_mobile_android.platform.ui.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.platform.utils.handleNetworkError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: UserRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Normal)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

     fun signInAction(email:String, keyword: String) {
         _uiState.value = UiState.Loading
         viewModelScope.launch {
             val authResult = repository.authenticate(email,keyword)
             authResult.collect { result ->
                 result.onSuccess { message ->
                     _uiState.value = UiState.Success(result.getOrNull().orEmpty())
                 }.onFailure { exception ->
                     val errorMessage = handleNetworkError(exception as Exception)
                     _uiState.value = UiState.NetworkError(errorMessage)
                 }
             }
         }
    }
}