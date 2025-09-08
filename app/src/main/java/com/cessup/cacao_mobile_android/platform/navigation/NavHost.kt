package com.cessup.cacao_mobile_android.platform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cessup.cacao_mobile_android.platform.ui.eatable.DrinksScreen
import com.cessup.cacao_mobile_android.platform.ui.home.HomeScreen
import com.cessup.cacao_mobile_android.platform.ui.network.NetworkErrorScreen
import com.cessup.cacao_mobile_android.platform.ui.session.ForgotScreen
import com.cessup.cacao_mobile_android.platform.ui.session.SignInScreen
import com.cessup.cacao_mobile_android.platform.ui.session.SignUpScreen

/**
 * The NavHost in Compose
 *
 * There are all graphs about every flow in the application
 *
 * @author
 *     Cessup
 * @since 1.0
 */
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AuthGraph.Root.route) {
        generalNavGraph(navController)
        authNavGraph(navController)
        homeNavGraph(navController)
    }
}

/**
 * generalNavGraph is the function navigate in home flow
 *
 * @param navController the navController is the view control
 *
 */
fun NavGraphBuilder.generalNavGraph(navController: NavController) {
    navigation(
        route = GeneralGraph.Root.route,
        startDestination = GeneralGraph.NetworkError.route
    ) {
        composable(
            route = GeneralGraph.NetworkError.routeWithArgs,
            arguments = listOf(
                navArgument(GeneralGraph.DataShare.ERROR_VALUE.name) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val error = backStackEntry.arguments?.getString(GeneralGraph.DataShare.ERROR_VALUE.name) ?: ""
            NetworkErrorScreen(error = error)
        }
    }
}

/**
 * authNavGraph is the function navigate in session flow
 *
 * @param navController the navController is the view control
 *
 */
fun NavGraphBuilder.authNavGraph(
    navController: NavController) {

    navigation(
        route = AuthGraph.Root.route,
        startDestination = AuthGraph.SignIn.route
    ) {

        composable(AuthGraph.SignIn.route) {
            SignInScreen(
                onNavNetworkError = {
                    navController.navigate(GeneralGraph.NetworkError.withArgs(error= it))
                },
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

/**
 * homeNavGraph is the function navigate in home flow
 *
 * @param navController the navController is the view control
 *
 */
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
            HomeScreen(token = token,{
                navController.navigate(HomeGraph.DrinkMenu.route)
            })
        }

        composable(HomeGraph.DrinkMenu.route) {
            DrinksScreen()
        }
    }
}


