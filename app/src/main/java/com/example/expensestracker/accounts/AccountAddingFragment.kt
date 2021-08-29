package com.example.expensestracker.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.databinding.FragmentAccountAddingBinding
import com.example.expensestracker.main.MainFragment
import com.example.expensestracker.viewModels.AccountsViewModel

class AccountAddingFragment : Fragment() {

    private val viewModel: AccountsViewModel by viewModels()

    private var binding: FragmentAccountAddingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAccountAddingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonAdd = binding?.buttonAccountAdding

        buttonAdd?.setOnClickListener { onClickListener() }
    }

    private fun onClickListener(): Boolean {
        val name = binding?.etNewAccountName
        val balance = binding?.etNewAccountBalance
        val checker = NewAccountValidation.validateData(name, balance)
        if(checker) {
            val balanceAmount: Int = Integer.parseInt(balance?.text.toString())
            viewModel.addAccount(AccountEntity(name?.text.toString(), R.drawable.ic_treasure,
                balanceAmount))
            return false
        }
        else {
            Toast.makeText(requireContext(), resources.getString(R.string.account_error),
                Toast.LENGTH_LONG).show()
            return false
        }
    }



}