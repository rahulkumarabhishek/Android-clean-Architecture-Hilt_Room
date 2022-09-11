package com.example.nutmegtest.localdb.enities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "photo_id")
    val photoId: Int?,

    @ColumnInfo(name = "album_id")
    val albumId: Int?,

    @ColumnInfo(name = "photo_title")
    val photoTitle: String?,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String?,

    @ColumnInfo(name = "photo_url")
    val photoUrl: String?
)