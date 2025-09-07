package com.cessup.cacao_mobile_android.data.source.remote

import com.cessup.cacao_mobile_android.data.entities.eatable.drink.BeerEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface DrinkService {
    @POST("eatable/drinks/beer/new")
    suspend fun newBeer(
        @Body request: BeerEntity
    ): Response<String>

    @PUT("eatable/drinks/beer/update")
    suspend fun updateBeer(
        @Body request: BeerEntity
    ): Response<String>

    @DELETE("eatable/drinks/beer/delete")
    suspend fun deleteBeer(
        @Body request: String
    ): Response<String>

    @GET("eatable/drinks/beer/get")
    suspend fun getBeers(): Response<List<BeerEntity>>
}