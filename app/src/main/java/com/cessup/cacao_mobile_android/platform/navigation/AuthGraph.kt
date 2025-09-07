package com.cessup.cacao_mobile_android.platform.navigation

sealed class AuthGraph(val route: String) {
    object Root : AuthGraph("auth")

    object SignIn : AuthGraph("auth/sign_in")
    object SignUp : AuthGraph("auth/sign_up")
    object Forgot : AuthGraph("auth/forgot")
}