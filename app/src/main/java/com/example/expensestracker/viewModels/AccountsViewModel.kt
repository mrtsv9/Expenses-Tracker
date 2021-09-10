package com.example.expensestracker.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.example.expensestracker.database.AccountDatabase
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.repositories.AccountsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow


class AccountsViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<AccountEntity>>
    private val getSummaryBalance: LiveData<List<Int>>
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

    fun updateAccount(account: AccountEntity) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.updateAccount(account)
        }
    }

//    fun getAccount(name: String): AccountEntity {
//        val result = AccountEntity
//        viewModelScope.launch {
//           val account =  repository.getAccount(name)
//           result.value = account
//        }
//        return result
//    }

}