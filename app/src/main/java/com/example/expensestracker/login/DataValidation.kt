package com.example.expensestracker.login

import android.app.Activity
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

object DataValidation : Activity() {

    fun validateData(
        loginLayout: TextInputLayout,
        login: TextInputEditText,
        passwordLayout: TextInputLayout,
        password: TextInputEditText
    ): Boolean {
        return !(!validateLogin(loginLayout, login)
                or !validatePassword(passwordLayout, password))
    }

    private fun validateLogin(
        loginLayout: TextInputLayout,
        login: TextInputEditText): Boolean {
        val loginInput = login.text.toString().trim()
        if (loginInput.isEmpty()) {
            loginLayout.error = "Filed cant be empty!"
            return false
        }
        return if (loginInput.length > 20) {
            loginLayout.error = "It is too long!"
            false
        } else {
            loginLayout.error = null
            true
        }
    }
    private fun validatePassword(
        passwordLayout: TextInputLayout,
        password: TextInputEditText): Boolean {
        val passwordInput = password.text.toString().trim()
        return if (passwordInput.isEmpty()) {
            passwordLayout.error = "Filed cant be empty!"
            false
        } else {
            passwordLayout.error = null
            true
        }
    }


}