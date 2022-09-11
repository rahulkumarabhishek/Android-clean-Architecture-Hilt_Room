package com.example.domain.repositories

import com.example.domain.models.UserCard
import io.reactivex.Maybe
import io.reactivex.disposables.Disposable

interface UserAlbumRepo {
    fun getUsersCardData(userId: Int=1): Maybe<UserCard>
    fun initialize(): Disposable?
}