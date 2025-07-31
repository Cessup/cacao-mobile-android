package com.cessup.cacao_mobile_android.platform.utils

import android.content.Context
import android.content.Intent
import com.cessup.cacao_mobile_android.platform.ui.home.HomeActivity
import com.cessup.cacao_mobile_android.platform.ui.session.ForgotActivity
import com.cessup.cacao_mobile_android.platform.ui.session.SignInActivity
import com.cessup.cacao_mobile_android.platform.ui.session.SignUpActivity

/**
 * Router helps to navigate in different screens
 *
 * @param Context the context in the applications that is use in the intent.
 *
 * @author
 *     Cessup
 * @since 1.0
 */
class Router(private val context: Context) {
    fun navigateToSignIn(){
        val intent = Intent(context, SignInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun navigateToSignUp(){
        val intent = Intent(context, SignUpActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun navigateToForgot(){
        val intent = Intent(context, ForgotActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun navigateToHome(){
        val intent = Intent(context, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
    }
}