package com.example.nutmegtest.localdb.repositories

import com.example.nutmegtest.localdb.enities.AlbumEntity

interface AlbumLocalRepo {
    fun getAllAlbumFromLocal(): List<AlbumEntity>
    fun saveAlbumToLocal(albumList: List<AlbumEntity>)
}