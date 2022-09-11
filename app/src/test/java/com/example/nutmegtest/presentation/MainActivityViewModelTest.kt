package com.example.nutmegtest.presentation

import com.example.domain.models.UserCard
import com.example.domain.usecases.UserAlbumUseCase
import com.example.nutmegtest.FakeUserAlbumRepo
import org.junit.Before
import org.junit.Test


class MainActivityViewModelTest {
    private lateinit var fakeUserAlbumRepo: FakeUserAlbumRepo
    private lateinit var userCardUseCase: UserAlbumUseCase
    private lateinit var viewModel: MainActivityViewModel

    @Before
    fun setUp() {
        fakeUserAlbumRepo = FakeUserAlbumRepo()
        userCardUseCase = UserAlbumUseCase(fakeUserAlbumRepo)
        viewModel = MainActivityViewModel(userCardUseCase)
    }

    @Test
    fun testGetUserAlbum() {
        val userCard = UserCard()
        val res = userCardUseCase.getUserAlbum(1)
        val observer = res.test()
        observer.awaitTerminalEvent()
        observer.assertNoErrors().assertComplete().assertValue(userCard)
    }

}