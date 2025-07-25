package com.cessup.cacao_mobile_android.data.source.local.db.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert suspend fun insert(userEntity: UserEntity)
    @Update suspend fun update(userEntity: UserEntity)
    @Delete suspend fun delete(userEntity: UserEntity)
    @Query("SELECT * FROM users WHERE username = :name LIMIT 1")
    fun findByName(name: String): LiveData<UserEntity?>
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>
}