package com.example.nutmegtest.localdb.repositories

import com.example.nutmegtest.localdb.dao.AlbumDao
import com.example.nutmegtest.localdb.enities.AlbumEntity
import javax.inject.Inject

class AlbumLocalRepoImpl @Inject constructor(private val albumDao: AlbumDao) : AlbumLocalRepo {
    override fun getAllAlbumFromLocal(): List<AlbumEntity> {
        return albumDao.getAll()
    }

    override fun saveAlbumToLocal(albumList: List<AlbumEntity>) {
        albumDao.deleteAll()
        albumDao.insertAll(albumList)
    }
}