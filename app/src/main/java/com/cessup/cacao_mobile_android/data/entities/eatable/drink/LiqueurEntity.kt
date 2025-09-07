package com.cessup.cacao_mobile_android.data.entities.eatable.drink

import com.cessup.cacao_mobile_android.data.entities.eatable.BrandEntity

/**
 * Represents a Liqueur drink.
 *
 * @property id unique identifier
 * @property description the description is a text about the drink
 * @property imgURL the imgURL is a text about the drink
 * @property brandEntity the brand is the information about brand of the drink
 * @property drinkEntity the drink is all information about this
 *
 * @author
 *     Cessup
 * @since 1.0
 */
data class LiqueurEntity(
    val id: String,
    val description:String,
    val imgURL: String,
    val brandEntity: BrandEntity,
    val drinkEntity: DrinkEntity,
)