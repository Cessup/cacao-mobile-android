package com.cessup.domain.models.eatable.meal

import com.cessup.domain.models.eatable.Energy

/**
 * Represents a Beer drink.
 *
 * @property id unique identifier
 * @property name the name of the meal
 * @property temperature the temperature is a ideal to this food
 * @property energy the energy is the information about the food
 *
 * @author
 *     Cessup
 * @since 1.0
 */
data class Meal(
     val id: String,
     val name: String,
     val temperature: Double,
     val energy: Energy
)