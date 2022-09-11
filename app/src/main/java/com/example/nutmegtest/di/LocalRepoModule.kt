package com.example.nutmegtest.di

import com.example.nutmegtest.localdb.PhotoLocalRepo
import com.example.nutmegtest.localdb.PhotoLocalRepoImpl
import com.example.nutmegtest.localdb.dao.AlbumDao
import com.example.nutmegtest.localdb.dao.PhotoDao
import com.example.nutmegtest.localdb.dao.UserDao
import com.example.nutmegtest.localdb.repositories.AlbumLocalRepo
import com.example.nutmegtest.localdb.repositories.AlbumLocalRepoImpl
import com.example.nutmegtest.localdb.repositories.UsersLocalRepo
import com.example.nutmegtest.localdb.repositories.UsersLocalRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalRepoModule {
    @Provides
    @Singleton
    fun providePhotoLocalRepo(photoDao: PhotoDao): PhotoLocalRepo {
        return PhotoLocalRepoImpl(photoDao)
    }

    @Provides
    @Singleton
    fun provideAlbumLocalRepo(albumDao: AlbumDao): AlbumLocalRepo {
        return AlbumLocalRepoImpl(albumDao)
    }

    @Provides
    @Singleton
    fun provideUsersLocalRepo(userDao: UserDao): UsersLocalRepo {
        return UsersLocalRepoImpl(userDao)
    }
}