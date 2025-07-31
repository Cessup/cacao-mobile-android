package com.cessup.cacao_mobile_android.data.source.remote

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
    //private const val BASE_URL = "http://10.0.2.2:8080/"
    private const val BASE_URL = "http://192.168.100.7:8080/"

    /**
     * This function give a instance of ApiService
     *
     * @return ApiService that is the object with all services.
     */
    val retrofitInstance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}