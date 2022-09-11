package com.example.nutmegtest.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nutmegtest.localdb.dao.AlbumDao
import com.example.nutmegtest.localdb.dao.PhotoDao
import com.example.nutmegtest.localdb.dao.UserDao
import com.example.nutmegtest.localdb.enities.AlbumEntity
import com.example.nutmegtest.localdb.enities.PhotoEntity
import com.example.nutmegtest.localdb.enities.UsersEntity

@Database(entities = [PhotoEntity::class,UsersEntity::class,AlbumEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
    abstract fun albumDao(): AlbumDao
    abstract fun usersDao(): UserDao
}