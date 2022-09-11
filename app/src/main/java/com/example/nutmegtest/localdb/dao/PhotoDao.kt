package com.example.nutmegtest.localdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nutmegtest.localdb.enities.PhotoEntity
import com.example.nutmegtest.localdb.enities.UserAlbumEntity
import io.reactivex.Maybe

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(photoEntity: List<PhotoEntity>)

    @Query("SELECT * FROM photo")
    fun getAll(): List<PhotoEntity>

    @Query("DELETE FROM photo")
    fun deleteAll()

    @Query("select * from photo  inner join album on album.album_id = photo.album_id inner join users on users.user_id=:userId and photo_id=1")
    fun getUserAlbumData(userId:Int) : Maybe<UserAlbumEntity>
}