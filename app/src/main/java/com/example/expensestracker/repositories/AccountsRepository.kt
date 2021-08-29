package com.example.expensestracker.repositories

import androidx.lifecycle.LiveData
import com.example.expensestracker.dao.AccountDao
import com.example.expensestracker.database.AccountEntity

class AccountsRepository(private val accountDao: AccountDao) {

    val readAllData = accountDao.readAllData()
    val getSummaryBalance = accountDao.getSummaryBalance()

    suspend fun addAccount(account: AccountEntity) {
        accountDao.addAccount(account)
    }

}