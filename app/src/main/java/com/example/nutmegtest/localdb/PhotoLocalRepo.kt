package com.example.nutmegtest.localdb

import com.example.nutmegtest.localdb.enities.PhotoEntity
import com.example.nutmegtest.localdb.enities.UserAlbumEntity
import io.reactivex.Maybe

interface PhotoLocalRepo {
    fun getAllPhotoFromLocal(): List<PhotoEntity>
    fun savePhotoToLocal(photoList: List<PhotoEntity>)
    fun getUserCard(id:Int) : Maybe<UserAlbumEntity>
}