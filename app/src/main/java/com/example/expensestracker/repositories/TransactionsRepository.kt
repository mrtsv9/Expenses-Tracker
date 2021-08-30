package com.example.expensestracker.repositories

import com.example.expensestracker.dao.TransactionDao
import com.example.expensestracker.database.TransactionEntity

class TransactionsRepository(private val transactionDao: TransactionDao) {

    val readAllData = transactionDao.readAllData()

    suspend fun addTransaction(transaction: TransactionEntity) {
        transactionDao.addTransaction(transaction)
    }
}