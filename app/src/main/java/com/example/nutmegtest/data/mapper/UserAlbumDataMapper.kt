package com.example.nutmegtest.data.mapper

import com.example.domain.models.UserCard
import com.example.nutmegtest.Mapper
import com.example.nutmegtest.localdb.enities.UserAlbumEntity
import javax.inject.Inject

class UserAlbumDataMapper @Inject constructor() : Mapper<UserAlbumEntity,UserCard> {
    override fun toEntity(e: UserCard): UserAlbumEntity {
        TODO("Not yet implemented")
    }

    override fun toData(t: UserAlbumEntity): UserCard {
        return UserCard(photoTitle = t.photoTitle, albumName = t.albumName, username = t.userName, thumbnail = t.thumbnail)
    }
}