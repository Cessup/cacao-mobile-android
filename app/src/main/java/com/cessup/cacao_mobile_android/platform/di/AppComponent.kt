package com.cessup.cacao_mobile_android.platform.di

import com.cessup.cacao_mobile_android.platform.ui.home.HomeActivity
import com.cessup.cacao_mobile_android.platform.ui.session.ForgotActivity
import com.cessup.cacao_mobile_android.platform.ui.session.SignInActivity
import com.cessup.cacao_mobile_android.platform.ui.session.SignUpActivity
import dagger.Component
import javax.inject.Singleton

/**
 * AppComponent got all modules to inject in the application.
 *
 * @author
 *     Cessup
 * @since 1.0
 */
@Singleton
@Component(modules = [AppModule::class,ViewModelModule::class])
interface AppComponent {
    /**
     * This function inject a Activity
     *
     * @param SignInActivity this activity is the view about session
     */
    fun inject(activity: SignInActivity)
    /**
     * This function inject a Activity
     *
     * @param SignUpActivity this activity is the view about register
     */
    fun inject(activity: SignUpActivity)
    /**
     * This function inject a Activity
     *
     * @param ForgotActivity this activity is the view about reset password
     */
    fun inject(activity: ForgotActivity)
    /**
     * This function inject a Activity
     *
     * @param HomeActivity this activity is the view about home
     */
    fun inject(activity: HomeActivity)
}