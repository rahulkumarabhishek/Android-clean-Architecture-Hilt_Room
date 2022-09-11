package com.example.nutmegtest.di

import com.example.nutmegtest.remote.RemoteApiRepo
import com.example.nutmegtest.remote.apiservices.ApiService
import com.example.nutmegtest.remote.RemoteApiRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteApiRepoModule {

    @Provides
    @Singleton
    fun provideRemoteApiRepoModule(api: ApiService): RemoteApiRepo {
        return RemoteApiRepoImpl(api)
    }
}