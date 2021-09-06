package com.example.expensestracker.accounts

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.example.expensestracker.R
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.databinding.FragmentAccountUpdatingBinding
import com.example.expensestracker.viewModels.AccountsViewModel

class AccountUpdatingFragment(
    val tvBalance: TextView?,
    val account: AccountEntity
    ) : Fragment() {

    private var binding: FragmentAccountUpdatingBinding? = null
    private val viewModel: AccountsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAccountUpdatingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = binding?.buttonAccountAddingUpdate
        val name = binding?.etNewAccountNameUpdate
        val balance = binding?.etNewAccountBalanceUpdate
        name?.isEnabled = false
        name?.setText(account.name)
        balance?.setText(account.balance.toString())


        button?.setOnClickListener { onClickListener() }
    }

    private fun onClickListener() {
        val name = binding?.etNewAccountNameUpdate
        val balance = binding?.etNewAccountBalanceUpdate
        val checker = NewAccountValidation.validateData(name, balance)
        if(checker) {

            val balanceAmount: Int = Integer.parseInt(balance?.text.toString())
            val updatedAccount = AccountEntity(account.name, account.image, balanceAmount)

            viewModel.updateAccount(updatedAccount)

            var tempBalance = Integer.parseInt(tvBalance?.text?.toString())
            tempBalance += balanceAmount
            tvBalance?.text = tempBalance.toString()

            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, AccountsFragment())
            transaction.commit()
        }
        else {
            Toast.makeText(requireContext(), resources.getString(R.string.account_error),
                Toast.LENGTH_LONG).show()
        }
    }

    fun updateAccountBalance(balance: Int?) {

    }

}