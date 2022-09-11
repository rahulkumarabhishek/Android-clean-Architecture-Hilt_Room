package com.example.nutmegtest.localdb.enities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "album_id")
    val albumId: Int?,
    @ColumnInfo(name = "user_id")
    val userId: Int?,
    @ColumnInfo(name = "album_name")
    val albumName: String?
)
