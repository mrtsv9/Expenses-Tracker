package com.example.expensestracker.repositories

import kotlinx.coroutines.flow.Flow
import com.example.expensestracker.dao.AccountDao
import com.example.expensestracker.database.AccountEntity

class AccountsRepository(private val accountDao: AccountDao) {

    val readAllData = accountDao.readAllData()
    val getSummaryBalance = accountDao.getSummaryBalance()

    suspend fun addAccount(account: AccountEntity) {
        accountDao.addAccount(account)
    }

    suspend fun updateAccount(account: AccountEntity) {
        accountDao.updateAccount(account)
    }

    suspend fun getAccount(name: String): AccountEntity {
        return accountDao.getAccount(name)
    }

}