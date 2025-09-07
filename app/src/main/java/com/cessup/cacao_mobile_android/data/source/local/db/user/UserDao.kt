package com.cessup.cacao_mobile_android.data.source.local.db.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * User DAO is an interface about user table in the database.
 *
 * There are functions about control user data.
 *
 * @author
 *     Cessup
 * @since 1.0
 */
@Dao
interface UserDao {
    /**
     * This function insert a user in the user table.
     *
     * @property userEntity unique identifier
     */
    @Insert suspend fun insert(userEntity: UserEntity)
    /**
     * This function update a user in the user table.
     *
     * @property userEntity unique identifier
     */
    @Update suspend fun update(userEntity: UserEntity)
    /**
     * This function delete a user in the user table.
     *
     * @property userEntity unique identifier
     */
    @Delete suspend fun delete(userEntity: UserEntity)
    /**
     * This function insert a user in the user table.
     *
     * @property uid unique identifier of the user to help to find it in database
     *
     * @return [Boolean] this value is the result of the delete operation
     */
    @Query("SELECT * FROM users WHERE uid = :uid LIMIT 1")
    fun findById(uid: String): Boolean
    /**
     * This function insert a user in the user table.
     *
     * @property userEntity unique identifier
     *
     * @return [Flow<List<UserEntity>>] Get All users in user table of database.
     */
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>
}