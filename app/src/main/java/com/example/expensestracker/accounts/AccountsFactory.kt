package com.example.expensestracker.accounts

import android.app.Application
import com.example.expensestracker.R
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.viewModels.AccountsViewModel

object AccountsFactory: Application() {

    fun createWallet(): AccountEntity {
        return AccountEntity("Wallet",R.drawable.ic_wallet, 300)
    }

    fun createCard(): AccountEntity {
        return AccountEntity("Card", R.drawable.ic_credit_card, 300)
    }

}