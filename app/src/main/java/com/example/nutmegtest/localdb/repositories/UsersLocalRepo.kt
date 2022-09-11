package com.example.nutmegtest.localdb.repositories

import com.example.nutmegtest.localdb.enities.UsersEntity

interface UsersLocalRepo {
    fun getAllUsersFromLocal(): List<UsersEntity>
    fun saveUsersToLocal(userList: List<UsersEntity>)
}