package com.cessup.cacao_mobile_android.platform.navigation

/**
 * The GeneralGraph is a component with the routes
 *
 * @constructor route that is the reference to use in the Graph
 *
 * @author
 *     Cessup
 * @since 1.0
 */
sealed class GeneralGraph(val route: String) {
    object Root : GeneralGraph("general")

    object NetworkError : HomeGraph("general/networkError"){
        const val routeWithArgs = "general/networkError/{ERROR_VALUE}"
        fun withArgs(error: String) = "general/networkError/$error"
    }

    enum class DataShare{
        ERROR_VALUE
    }
}