package com.example.expensestracker.accounts

import com.example.expensestracker.R

object AccountsFactory {

    fun createBaseAccounts(list: ArrayList<SingleAccount>): ArrayList<SingleAccount> {
        list.add(SingleAccount("Wallet",R.drawable.ic_wallet, 30))
        list.add(SingleAccount("Card", R.drawable.ic_credit_card, 30))

        return list
    }

}