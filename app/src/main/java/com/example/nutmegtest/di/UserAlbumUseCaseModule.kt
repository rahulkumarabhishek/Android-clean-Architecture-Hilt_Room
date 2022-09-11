package com.example.nutmegtest.di

import com.example.domain.repositories.UserAlbumRepo
import com.example.nutmegtest.data.mapper.AlbumDataMapper
import com.example.nutmegtest.data.mapper.PhotoDataMapper
import com.example.nutmegtest.data.mapper.UserAlbumDataMapper
import com.example.nutmegtest.data.mapper.UserDataMapper
import com.example.nutmegtest.data.repository.UserAlbumRepoImpl
import com.example.nutmegtest.localdb.PhotoLocalRepo
import com.example.nutmegtest.localdb.repositories.AlbumLocalRepo
import com.example.nutmegtest.localdb.repositories.UsersLocalRepo
import com.example.nutmegtest.remote.RemoteApiRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserAlbumUseCaseModule {
    @Provides
    @Singleton
    fun provideUserAlbum(
        remoteApiRepo: RemoteApiRepo,
        photoLocalRepo: PhotoLocalRepo,
        usersLocalRepo: UsersLocalRepo,
        albumLocalRepo: AlbumLocalRepo,
        photoDataMapper: PhotoDataMapper,
        albumDataMapper: AlbumDataMapper,
        userDataMapper: UserDataMapper,
        userAlbumDataMapper: UserAlbumDataMapper
    ): UserAlbumRepo {
        return UserAlbumRepoImpl(
            remoteApiRepo,
            photoLocalRepo,
            usersLocalRepo,
            albumLocalRepo,
            photoDataMapper,
            albumDataMapper,
            userDataMapper,
            userAlbumDataMapper
        )
    }

}