package com.example.nutmegtest.localdb.enities

import androidx.room.ColumnInfo

data class UserAlbumEntity(
    @ColumnInfo(name = "photo_title")
    val photoTitle: String="",
    @ColumnInfo(name = "album_name")
    val albumName: String="",
    @ColumnInfo(name = "thumbnail")
    val thumbnail: String="",
    @ColumnInfo(name = "user_name")
    val userName: String=""
)