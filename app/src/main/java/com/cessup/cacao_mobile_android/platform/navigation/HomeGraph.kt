package com.cessup.cacao_mobile_android.platform.navigation

/**
 * The HomeGraph is a component with the routes
 *
 * @constructor route that is the reference to use in the Graph
 *
 * @author
 *     Cessup
 * @since 1.0
 */
sealed class HomeGraph(val route: String) {
    object Root : HomeGraph("home")

    object Home : HomeGraph("home/start"){
        const val routeWithArgs = "home/start/{TOKEN_VALUE}"
        fun withArgs(token: String) = "home/start/$token"
    }

    object DrinkMenu : HomeGraph("home/start/drink")

    enum class DataShare{
        TOKEN_VALUE
    }
}