package com.cessup.cacao_mobile_android.platform.ui.session

import androidx.lifecycle.ViewModel
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotViewModel @Inject constructor(
    private val repository: UserRepositoryImpl
) : ViewModel() {

}