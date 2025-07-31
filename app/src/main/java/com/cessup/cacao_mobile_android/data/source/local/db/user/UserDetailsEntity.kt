package com.cessup.cacao_mobile_android.data.source.local.db.user

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a user.
 *
 * @property uid unique identifier
 * @property name the name of the user
 * @property lastName the lastname of the user
 * @property gender the gender of the user
 * @property birthdate the birthday of the user
 */
@Entity(tableName = "users_details")
data class UserDetailsEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int =0,
    val name: String,
    val lastName: String,
    val address: String,
    val gender: String,
    val birthdate : Long
)