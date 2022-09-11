package com.example.nutmegtest.localdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nutmegtest.localdb.enities.UsersEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(userEntity: List<UsersEntity>)

    @Query("SELECT * FROM users")
    fun getAll(): List<UsersEntity>

    @Query("DELETE FROM users")
    fun deleteAll()
}