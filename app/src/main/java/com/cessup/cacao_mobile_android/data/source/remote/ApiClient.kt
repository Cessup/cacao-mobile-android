package com.cessup.cacao_mobile_android.data.source.remote

import android.content.Context
import com.cessup.cacao_mobile_android.platform.utils.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * ApiClient is an object got service configurations
 *
 *
 * @author
 *     Cessup
 * @since 1.0
 */

object ApiClient {
    private const val BASE_URL = "http://10.0.2.2:8080/"
    /**
     * This function give a instance of ApiService
     *
     * @return ApiService that is the object with all services.
     */
    fun getInstance(context: Context): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(NetworkConnectionInterceptor(context))
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}