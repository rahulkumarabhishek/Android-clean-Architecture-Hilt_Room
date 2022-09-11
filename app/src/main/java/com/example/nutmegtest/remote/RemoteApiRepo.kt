package com.example.nutmegtest.remote

import com.example.nutmegtest.models.AlbumsItem
import com.example.nutmegtest.models.PhotosItem
import com.example.nutmegtest.models.UsersItem
import io.reactivex.Observable

interface RemoteApiRepo {
    fun getAllUsers(): Observable<List<UsersItem>>
    fun getAllAlbums(): Observable<List<AlbumsItem>>
    fun getAllPhotos(): Observable<List<PhotosItem>>
}