package com.example.nutmegtest.data.mapper

import com.example.nutmegtest.Mapper
import com.example.nutmegtest.localdb.enities.UsersEntity
import com.example.nutmegtest.models.UsersItem
import javax.inject.Inject

class UserDataMapper @Inject constructor(): Mapper<UsersItem,UsersEntity>{
    override fun toEntity(e: UsersEntity): UsersItem {
        TODO("Not yet implemented")
    }

    override fun toData(t: UsersItem): UsersEntity {
        return UsersEntity(userId = t.id, userName = t.name)
    }
}