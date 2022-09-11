package com.example.nutmegtest.remote.apiservices

import com.example.nutmegtest.models.AlbumsItem
import com.example.nutmegtest.models.PhotosItem
import com.example.nutmegtest.models.UsersItem
import retrofit2.http.GET
import io.reactivex.Observable

interface ApiService {
    @GET("photos")
    fun getPhotosFromApi(): Observable<List<PhotosItem>>

    @GET("users")
    fun getUsersFromApi(): Observable<List<UsersItem>>

    @GET("albums")
    fun getAlbumsFromAPi(): Observable<List<AlbumsItem>>
}