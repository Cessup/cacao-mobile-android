package com.cessup.cacao_mobile_android.platform.di

import com.cessup.cacao_mobile_android.platform.ui.home.HomeActivity
import com.cessup.cacao_mobile_android.platform.ui.session.ForgotActivity
import com.cessup.cacao_mobile_android.platform.ui.session.SignInActivity
import com.cessup.cacao_mobile_android.platform.ui.session.SignUpActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,ViewModelModule::class])
interface AppComponent {
    fun inject(activity: SignInActivity)
    fun inject(activity: SignUpActivity)
    fun inject(activity: ForgotActivity)
    fun inject(activity: HomeActivity)
}