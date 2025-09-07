package com.cessup.cacao_mobile_android.platform.ui.home

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.cessup.cacao_mobile_android.domain.model.User
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: UserRepository
) : ViewModel() {

    val users: StateFlow<List<User>> = repository.getAllUser()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
