package com.example.nutmegtest

import com.example.domain.models.UserCard
import com.example.domain.repositories.UserAlbumRepo
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FakeUserAlbumRepo:UserAlbumRepo {
    override fun getUsersCardData(userId: Int): Maybe<UserCard> {
        return Maybe.just(UserCard()).subscribeOn(Schedulers.io())
    }

    override fun initialize(): Disposable? {
        return Observable.just("").subscribe()
    }
}