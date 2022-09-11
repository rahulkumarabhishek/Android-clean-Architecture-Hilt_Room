package com.example.nutmegtest.localdb.repositories

import com.example.nutmegtest.localdb.dao.UserDao
import com.example.nutmegtest.localdb.enities.UsersEntity
import javax.inject.Inject

class UsersLocalRepoImpl @Inject constructor(private val userDao: UserDao) : UsersLocalRepo {
    override fun getAllUsersFromLocal(): List<UsersEntity> {
        return userDao.getAll()
    }

    override fun saveUsersToLocal(userList: List<UsersEntity>) {
        userDao.insertAll(userList)
    }
}