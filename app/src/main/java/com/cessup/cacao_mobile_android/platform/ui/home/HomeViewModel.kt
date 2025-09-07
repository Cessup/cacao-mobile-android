package com.cessup.cacao_mobile_android.platform.ui.home

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: UserRepository
) : ViewModel() {

}
