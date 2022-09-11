package com.example.nutmegtest.localdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nutmegtest.localdb.enities.AlbumEntity

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albumEntity: List<AlbumEntity>)

    @Query("SELECT * FROM album")
    fun getAll(): List<AlbumEntity>

    @Query("DELETE FROM album")
    fun deleteAll()
}