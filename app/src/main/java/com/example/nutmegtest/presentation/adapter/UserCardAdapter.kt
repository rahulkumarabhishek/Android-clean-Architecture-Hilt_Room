package com.example.nutmegtest.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.UserCard
import com.example.nutmegtest.R
import com.example.nutmegtest.databinding.UserCardRowItemsBinding

class UserCardAdapter(private val userCardList: ArrayList<UserCard>) :
    RecyclerView.Adapter<UserCardAdapter.ViewHolder>() {

    class ViewHolder(private val item: UserCardRowItemsBinding) :
        RecyclerView.ViewHolder(item.root) {
        fun bind(userCard: UserCard) {
            item.model = userCard
            item.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: UserCardRowItemsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.user_card_row_items,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userCardList[position])
    }

    override fun getItemCount(): Int {
        return userCardList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newItems: List<UserCard>) {
        userCardList.clear()
        userCardList.addAll(newItems)
        notifyDataSetChanged()
    }
}