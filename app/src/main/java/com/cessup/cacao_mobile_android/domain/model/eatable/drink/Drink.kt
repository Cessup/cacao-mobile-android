package com.cessup.domain.models.eatable.drink

import com.cessup.domain.models.eatable.Energy

/**
 * Represents a Product.
 *
 * @property id unique identifier
 * @property name the code for identify every product
 * @property temperature the price is about value of product
 * @property isAlcoholic the currency is a references of prices
 * @property millilitres the millilitres is the count per piece
 * @property energy the currency is a references of prices
 *
 * @author
 *     Cessup
 * @since 1.0
 */
data class Drink(
    val id: String,
    val name: String,
    val temperature: Double,
    val isAlcoholic: Boolean,
    val millilitres: Int,
    val energy: Energy,
)