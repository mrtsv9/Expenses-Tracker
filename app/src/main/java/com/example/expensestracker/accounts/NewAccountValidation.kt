package com.example.expensestracker.accounts

import android.widget.EditText
import android.widget.Toast

object NewAccountValidation {

    fun validateData(name: EditText?, balance: EditText?): Boolean {
        if(name!!.text.toString().isEmpty()) return false
        return balance!!.text.toString().isNotEmpty()
    }

}