package com.cessup.cacao_mobile_android.platform.navigation

sealed class HomeGraph(val route: String) {
    object Root : HomeGraph("home")

    object Home : HomeGraph("home/start"){
        const val routeWithArgs = "home/start/{TOKEN_VALUE}"
        fun withArgs(token: String) = "home/start/$token"
    }

    enum class DataShare{
        TOKEN_VALUE
    }
}