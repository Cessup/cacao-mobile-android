package com.cessup.cacao_mobile_android.platform.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cessup.cacao_mobile_android.platform.ui.eatable.DrinkViewModel
import com.cessup.cacao_mobile_android.platform.ui.home.HomeViewModel
import com.cessup.cacao_mobile_android.platform.ui.session.ForgotViewModel
import com.cessup.cacao_mobile_android.platform.ui.session.SignInViewModel
import com.cessup.cacao_mobile_android.platform.ui.session.SignUpViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun bindSignInViewModel(viewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun bindSignUpViewModel(viewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ForgotViewModel::class)
    abstract fun bindForgotViewModel(viewModel: ForgotViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DrinkViewModel::class)
    abstract fun bindDrinkViewModel(viewModel: DrinkViewModel): ViewModel
}