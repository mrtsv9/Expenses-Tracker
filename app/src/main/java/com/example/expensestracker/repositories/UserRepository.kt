package com.example.expensestracker.repositories

import com.example.expensestracker.database.UserEntity
import com.example.expensestracker.dao.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun addUser(user: UserEntity) {
        userDao.addUser(user)
    }

}