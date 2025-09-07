package com.cessup.domain.models.eatable

/**
 * Represents Brand abstraction to eat.
 *
 * @property id unique identifier
 * @property name unique identifier
 * @property description unique identifier
 * @property img unique identifier
 *
 * @author
 *     Cessup
 * @since 1.0
 */
data class Brand (
    val id: String,
    val name: String,
    val description:String,
    val img:String,
)