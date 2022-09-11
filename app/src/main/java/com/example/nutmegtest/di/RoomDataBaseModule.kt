package com.example.nutmegtest.di

import android.content.Context
import androidx.room.Room
import com.example.nutmegtest.localdb.AppDatabase
import com.example.nutmegtest.localdb.dao.AlbumDao
import com.example.nutmegtest.localdb.dao.PhotoDao
import com.example.nutmegtest.localdb.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomDataBaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "user_album.db"
        ).build()

    @Provides
    @Singleton
    fun providesPhotoDao(db: AppDatabase): PhotoDao = db.photoDao()

    @Provides
    @Singleton
    fun provideAlbumDao(db: AppDatabase): AlbumDao = db.albumDao()

    @Provides
    @Singleton
    fun provideUsersDao(db: AppDatabase): UserDao = db.usersDao()
}