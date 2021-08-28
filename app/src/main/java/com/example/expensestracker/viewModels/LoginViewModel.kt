package com.example.expensestracker.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensestracker.database.UserDatabase
import com.example.expensestracker.database.UserEntity
import com.example.expensestracker.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

    fun addUser(user: UserEntity) {
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.addUser(user)
        }
    }

}