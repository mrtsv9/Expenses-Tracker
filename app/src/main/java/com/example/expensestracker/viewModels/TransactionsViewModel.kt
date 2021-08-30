package com.example.expensestracker.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.database.TransactionDatabase
import com.example.expensestracker.database.TransactionEntity
import com.example.expensestracker.repositories.TransactionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionsViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<TransactionEntity>>
    private val repository: TransactionsRepository

    init {
        val transactionDao = TransactionDatabase.getDatabase(application).transactionDao()
        repository = TransactionsRepository(transactionDao)
        readAllData = repository.readAllData.asLiveData()
    }

    fun addTransaction(transaction: TransactionEntity) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.addTransaction(transaction)
        }
    }

}