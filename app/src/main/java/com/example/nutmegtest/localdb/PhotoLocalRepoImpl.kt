package com.example.nutmegtest.localdb

import com.example.nutmegtest.localdb.dao.PhotoDao
import com.example.nutmegtest.localdb.enities.PhotoEntity
import com.example.nutmegtest.localdb.enities.UserAlbumEntity
import io.reactivex.Maybe
import javax.inject.Inject

class PhotoLocalRepoImpl @Inject constructor(private val photoDao: PhotoDao) : PhotoLocalRepo {
    override fun getAllPhotoFromLocal(): List<PhotoEntity> {
        return photoDao.getAll()
    }

    override fun savePhotoToLocal(photoList: List<PhotoEntity>) {
        photoDao.deleteAll()
        photoDao.insertAll(photoList)
    }

    override fun getUserCard(id: Int): Maybe<UserAlbumEntity> {
        return photoDao.getUserAlbumData(id)
    }
}