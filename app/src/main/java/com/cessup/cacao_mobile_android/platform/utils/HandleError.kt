package com.cessup.cacao_mobile_android.platform.utils

import android.util.Log
import java.io.IOException
import java.net.SocketTimeoutException
import retrofit2.HttpException

fun handleNetworkError(e: Exception): String {
    return when (e) {
        is SocketTimeoutException -> {
            Log.e("NetworkError", "Timeout", e)
            "The server took too long to respond. Please try again."
        }

        is IOException -> {
            Log.e("NetworkError", "No Internet / Network issue", e)
            "No internet connection. Please check your network and try again."
        }

        is HttpException -> {
            Log.e("NetworkError", "HTTP error ${e.code()}", e)
            when (e.code()) {
                401 -> "Unauthorized access. Please login again."
                403 -> "You don't have permission to access this resource."
                404 -> "Requested resource not found."
                500 -> "Server error. Please try again later."
                else -> "HTTP error ${e.code()}: ${e.message()}"
            }
        }

        else -> {
            Log.e("NetworkError", "Unknown error", e)
            "An unexpected error occurred: ${e.localizedMessage}"
        }
    }
}