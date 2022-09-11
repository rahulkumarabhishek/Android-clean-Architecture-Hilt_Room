package com.example.nutmegtest.data.mapper

import com.example.nutmegtest.Mapper
import com.example.nutmegtest.localdb.enities.AlbumEntity
import com.example.nutmegtest.models.AlbumsItem
import javax.inject.Inject

class AlbumDataMapper @Inject constructor() : Mapper<AlbumsItem,AlbumEntity>{
    override fun toEntity(e: AlbumEntity): AlbumsItem {
        TODO("Not yet implemented")
    }

    override fun toData(t: AlbumsItem): AlbumEntity {
        return AlbumEntity(albumId = t.id, userId = t.userId, albumName = t.title)
    }
}