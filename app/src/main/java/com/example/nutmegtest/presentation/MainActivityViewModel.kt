package com.example.nutmegtest.presentation


import androidx.lifecycle.ViewModel
import com.example.domain.models.UserCard
import com.example.domain.usecases.UserAlbumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val useCase: UserAlbumUseCase) :
    ViewModel() {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var listener:UpdateUserAdapterListener?=null

    init {
        useCase.initialize()?.let { compositeDisposable.add(it) }
    }

    fun getUserCard() {
        val userCardList = ArrayList<UserCard>()
        for (i in 1..10) {
            compositeDisposable.add(
                useCase.getUserAlbum(i).observeOn(AndroidSchedulers.mainThread()).subscribe {
                    userCardList.add(it)
                    listener?.onUpdateUserAdapter(userCardList)
                })
        }
    }

    fun onDestroy() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

    fun setListener(reference: UpdateUserAdapterListener) {
        this.listener = reference
    }

}
interface UpdateUserAdapterListener{
    fun onUpdateUserAdapter(userCardList: ArrayList<UserCard>)
}