package com.cessup.cacao_mobile_android.data.entities.eatable.meal

import com.cessup.cacao_mobile_android.data.entities.eatable.EnergyEntity

/**
 * Represents a Beer drink.
 *
 * @property id unique identifier
 * @property name the name of the meal
 * @property temperature the temperature is a ideal to this food
 * @property energyEntity the energy is the information about the food
 *
 * @author
 *     Cessup
 * @since 1.0
 */
data class MealEntity(
     val id: String,
     val name: String,
     val temperature: Double,
     val energyEntity: EnergyEntity
)