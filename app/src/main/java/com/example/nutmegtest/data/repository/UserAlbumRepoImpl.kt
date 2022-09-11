package com.example.nutmegtest.data.repository

import com.example.domain.models.UserCard
import com.example.domain.repositories.UserAlbumRepo
import com.example.nutmegtest.data.mapper.AlbumDataMapper
import com.example.nutmegtest.data.mapper.PhotoDataMapper
import com.example.nutmegtest.data.mapper.UserAlbumDataMapper
import com.example.nutmegtest.data.mapper.UserDataMapper
import com.example.nutmegtest.localdb.PhotoLocalRepo
import com.example.nutmegtest.localdb.enities.AlbumEntity
import com.example.nutmegtest.localdb.enities.PhotoEntity
import com.example.nutmegtest.localdb.enities.UsersEntity
import com.example.nutmegtest.localdb.repositories.AlbumLocalRepo
import com.example.nutmegtest.localdb.repositories.UsersLocalRepo
import com.example.nutmegtest.remote.RemoteApiRepo
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserAlbumRepoImpl @Inject constructor(
    private val remoteApiRepo: RemoteApiRepo,
    private val photoLocalRepo: PhotoLocalRepo,
    private val usersLocalRepo: UsersLocalRepo,
    private val albumLocalRepo: AlbumLocalRepo,
    private val photoDataMapper: PhotoDataMapper,
    private val albumDataMapper: AlbumDataMapper,
    private val userDataMapper: UserDataMapper,
    private val userAlbumDataMapper: UserAlbumDataMapper
) : UserAlbumRepo {
    override fun getUsersCardData(userId: Int): Maybe<UserCard> {
        return photoLocalRepo.getUserCard(userId).map {
            return@map userAlbumDataMapper.toData(it)
        }.subscribeOn(Schedulers.io())
    }

    override fun initialize(): Disposable =
        Observable.merge(
            getPhotosFromRemoteAndSaveToLocalDatabase(),
            getUsersFromRemoteAndSaveToLocalDatabase(),
            getAlbumFromRemoteAndSaveToLocalDatabase()
        ).subscribe()

    private fun getPhotosFromRemoteAndSaveToLocalDatabase() =
        remoteApiRepo.getAllPhotos().map { photoItemList ->
            val photoEntityList = ArrayList<PhotoEntity>()
            for (item in photoItemList) {
                photoEntityList.add(photoDataMapper.toData(item))
            }
            photoLocalRepo.savePhotoToLocal(photoEntityList)
            return@map photoEntityList
        }.subscribeOn(Schedulers.io())


    private fun getUsersFromRemoteAndSaveToLocalDatabase() =
        remoteApiRepo.getAllUsers().map {
            val userEntityList = ArrayList<UsersEntity>()
            for (item in it) {
                userEntityList.add(userDataMapper.toData(item))
            }
            usersLocalRepo.saveUsersToLocal(userEntityList)
            return@map userEntityList
        }.subscribeOn(Schedulers.io())


    private fun getAlbumFromRemoteAndSaveToLocalDatabase() =
        remoteApiRepo.getAllAlbums().map {
            val albumEntityList = ArrayList<AlbumEntity>()
            for (item in it) {
                albumEntityList.add(albumDataMapper.toData(item))
            }
            albumLocalRepo.saveAlbumToLocal(albumEntityList)
            return@map albumEntityList
        }.subscribeOn(Schedulers.io())

}