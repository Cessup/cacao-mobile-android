package com.cessup.cacao_mobile_android.data.source.remote

import com.cessup.domain.models.eatable.meal.Meal
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MealService {
    @POST("/meals/example")
    suspend fun exampleService(
        @Body request: Meal
    ): Response<Meal>
}