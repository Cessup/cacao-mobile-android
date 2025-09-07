package com.cessup.domain.models.eatable.meal

import com.cessup.domain.models.eatable.Brand

/**
 * Represents a Beer drink.
 *
 * @property id unique identifier
 * @property meal the meal contain information about this food
 * @property description the description is a text about the food
 *
 * @author
 *     Cessup
 * @since 1.0
 */
data class Starter (
    val id:String,
    val description:String,
    val imgURL: String,
    val brand: Brand,
    val meal: Meal,
)