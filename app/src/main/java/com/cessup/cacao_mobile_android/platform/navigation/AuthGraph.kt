package com.cessup.cacao_mobile_android.platform.navigation

/**
 * The AuthGraph is a component with the routes
 *
 * @constructor route that is the reference to use in the Graph
 *
 * @author
 *     Cessup
 * @since 1.0
 */
sealed class AuthGraph(val route: String) {
    object Root : AuthGraph("auth")

    object SignIn : AuthGraph("auth/sign_in")
    object SignUp : AuthGraph("auth/sign_up")
    object Forgot : AuthGraph("auth/forgot")
}