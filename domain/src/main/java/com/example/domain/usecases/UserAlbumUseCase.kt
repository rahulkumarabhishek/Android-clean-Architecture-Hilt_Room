package com.example.domain.usecases

import com.example.domain.repositories.UserAlbumRepo
import javax.inject.Inject

class UserAlbumUseCase @Inject constructor(private val userAlbumRepo: UserAlbumRepo) {
     fun initialize()=userAlbumRepo.initialize()
     fun getUserAlbum(id: Int) = userAlbumRepo.getUsersCardData(id)
}