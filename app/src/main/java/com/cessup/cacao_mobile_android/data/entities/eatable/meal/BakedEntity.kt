package com.cessup.cacao_mobile_android.data.entities.eatable.meal

import com.cessup.cacao_mobile_android.data.entities.eatable.BrandEntity

/**
 * Represents a Beer drink.
 *
 * @property id unique identifier
 * @property mealEntity the meal contain information about this food
 * @property description the description is a text about the food
 *
 * @author
 *     Cessup
 * @since 1.0
 */
data class BakedEntity (
    val id: String,
    val description:String,
    val imgURL: String,
    val brandEntity: BrandEntity,
    val mealEntity: MealEntity,
)