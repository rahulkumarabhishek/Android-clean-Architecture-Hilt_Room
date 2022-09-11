package com.example.nutmegtest.remote

import com.example.nutmegtest.models.AlbumsItem
import com.example.nutmegtest.remote.apiservices.ApiService
import com.example.nutmegtest.models.PhotosItem
import com.example.nutmegtest.models.UsersItem
import io.reactivex.Observable
import javax.inject.Inject

class RemoteApiRepoImpl @Inject constructor(private val api: ApiService) : RemoteApiRepo {
    override fun getAllUsers(): Observable<List<UsersItem>> {
        return api.getUsersFromApi()
    }

    override fun getAllAlbums(): Observable<List<AlbumsItem>> {
       return api.getAlbumsFromAPi()
    }

    override fun getAllPhotos(): Observable<List<PhotosItem>> {
        return api.getPhotosFromApi()
    }

}