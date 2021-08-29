package com.example.expensestracker.repositories

import androidx.lifecycle.LiveData
import com.example.expensestracker.dao.AccountDao
import com.example.expensestracker.database.AccountEntity

class AccountsRepository(private val accountDao: AccountDao) {

    val readAllData = accountDao.readAllData()

    suspend fun addAccount(account: AccountEntity) {
        accountDao.addAccount(account)
    }

}