package com.example.nutmegtest.data.mapper

import com.example.nutmegtest.Mapper
import com.example.nutmegtest.localdb.enities.PhotoEntity
import com.example.nutmegtest.models.PhotosItem
import javax.inject.Inject

class PhotoDataMapper @Inject constructor() : Mapper<PhotosItem,PhotoEntity>{
    override fun toEntity(e: PhotoEntity): PhotosItem {
        TODO("Not yet implemented")
    }

    override fun toData(t: PhotosItem): PhotoEntity {
        return PhotoEntity(albumId = t.albumId, photoId = t.id, photoTitle = t.title, photoUrl = t.url, thumbnail = t.thumbnailUrl)
    }
}