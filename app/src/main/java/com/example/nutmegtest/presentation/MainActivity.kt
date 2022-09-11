package com.example.nutmegtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.domain.models.UserCard
import com.example.nutmegtest.R
import com.example.nutmegtest.databinding.ActivityMainBinding
import com.example.nutmegtest.presentation.adapter.UserCardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UpdateUserAdapterListener {
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView<ActivityMainBinding?>(this, R.layout.activity_main)
                .also {
                    it.model = viewModel
                }
        setContentView(binding.root)

        viewModel.getUserCard()
        viewModel.setListener(this)
        binding.adapter = UserCardAdapter(ArrayList())
        binding.recyclerUserCard.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    override fun onUpdateUserAdapter(userCardList: ArrayList<UserCard>) {
       if(::binding.isInitialized){
           binding.adapter?.update(userCardList)
       }
    }
}