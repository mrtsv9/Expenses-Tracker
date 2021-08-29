package com.example.expensestracker.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.expensestracker.database.AccountDatabase
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.repositories.AccountsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class AccountsViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<AccountEntity>>
    val getSummaryBalance: LiveData<List<Int>>
    private val repository: AccountsRepository

    init {
        val accountDao = AccountDatabase.getDatabase(application).accountDao()
        repository = AccountsRepository(accountDao)
        readAllData = repository.readAllData.asLiveData()
        getSummaryBalance = repository.getSummaryBalance.asLiveData()
    }

    fun addAccount(account: AccountEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAccount(account)
        }
    }

}