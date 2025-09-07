package com.cessup.cacao_mobile_android.platform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cessup.cacao_mobile_android.platform.ui.home.HomeScreen
import com.cessup.cacao_mobile_android.platform.ui.session.ForgotScreen
import com.cessup.cacao_mobile_android.platform.ui.session.SignInScreen
import com.cessup.cacao_mobile_android.platform.ui.session.SignUpScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AuthGraph.Root.route) {
        authNavGraph(navController)
        homeNavGraph(navController)
    }
}

fun NavGraphBuilder.authNavGraph(
    navController: NavController) {

    navigation(
        route = AuthGraph.Root.route,
        startDestination = AuthGraph.SignIn.route
    ) {

        composable(AuthGraph.SignIn.route) {
            SignInScreen(
                onSignInClick = {
                    navController.navigate(HomeGraph.Home.withArgs(token= it)) {
                        popUpTo(AuthGraph.Root.route) { inclusive = true }
                    }
                },
                onForgotPasswordClick = {
                    navController.navigate(AuthGraph.Forgot.route)
                },
                onRegisterClick = {
                    navController.navigate(AuthGraph.SignUp.route)
                }
            )
        }

        composable(AuthGraph.SignUp.route) {
            SignUpScreen(onSignUpClick = {
                navController.navigate(HomeGraph.Home.withArgs(token= "123")) {
                    popUpTo(AuthGraph.Root.route) { inclusive = true }
                }
            })
        }

        composable(AuthGraph.Forgot.route) {
            ForgotScreen(onNextOnClick = {
                navController.navigate(HomeGraph.Home.withArgs(token= "123")) {
                    popUpTo(AuthGraph.Root.route) { inclusive = true }
                }
            })
        }


    }
}

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        route = HomeGraph.Root.route,
        startDestination = HomeGraph.Home.route
    ) {
        composable(
            route = HomeGraph.Home.routeWithArgs,
            arguments = listOf(
                navArgument(HomeGraph.DataShare.TOKEN_VALUE.name) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val token = backStackEntry.arguments?.getString(HomeGraph.DataShare.TOKEN_VALUE.name) ?: ""
            HomeScreen(token = token)
        }
    }
}


