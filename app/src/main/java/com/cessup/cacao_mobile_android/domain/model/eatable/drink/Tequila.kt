package com.cessup.domain.models.eatable.drink

import com.cessup.domain.models.eatable.Brand

/**
 * Represents a Tequila drink.
 *
 * @property id unique identifier
 * @property description the description is a text about the drink
 * @property brand some drinks from a company
 * @property drink the drink is all information about this
 *
 * @author
 *     Cessup
 * @since 1.0
 */
data class Tequila(
    val id: String,
    val description:String,
    val imgURL: String,
    val brand: Brand,
    val drink: Drink,
)