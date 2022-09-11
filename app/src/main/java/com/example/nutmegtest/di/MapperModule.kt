package com.example.nutmegtest.di

import com.example.domain.models.UserCard
import com.example.nutmegtest.Mapper
import com.example.nutmegtest.data.mapper.AlbumDataMapper
import com.example.nutmegtest.data.mapper.PhotoDataMapper
import com.example.nutmegtest.data.mapper.UserAlbumDataMapper
import com.example.nutmegtest.data.mapper.UserDataMapper
import com.example.nutmegtest.localdb.enities.AlbumEntity
import com.example.nutmegtest.localdb.enities.PhotoEntity
import com.example.nutmegtest.localdb.enities.UserAlbumEntity
import com.example.nutmegtest.localdb.enities.UsersEntity
import com.example.nutmegtest.models.AlbumsItem
import com.example.nutmegtest.models.PhotosItem
import com.example.nutmegtest.models.UsersItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providePhotoMapperModule(): Mapper<PhotosItem, PhotoEntity> {
        return PhotoDataMapper()
    }

    @Provides
    fun provideUserMapperModule(): Mapper<UsersItem,UsersEntity> {
        return UserDataMapper()
    }

    @Provides
    fun provideAlbumMapperModule(): Mapper<AlbumsItem,AlbumEntity>{
        return AlbumDataMapper()
    }

    @Provides
    fun provideUserAlbumMapperModule(): Mapper<UserAlbumEntity,UserCard>{
        return UserAlbumDataMapper()
    }
}