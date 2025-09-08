package com.cessup.cacao_mobile_android.platform.utils

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtils.isNetworkAvailable(context)) {
            throw IOException("No Internet Connection")
        }
        return chain.proceed(chain.request())
    }
}