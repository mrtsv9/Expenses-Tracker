package com.example.expensestracker.fab_adding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.example.expensestracker.R
import com.example.expensestracker.accounts.AccountUpdatingFragment
import com.example.expensestracker.accounts.AccountsFragment
import com.example.expensestracker.categories.CategoriesFactory
import com.example.expensestracker.categories.CategoriesFragment
import com.example.expensestracker.categories.SingleCategory
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.database.TransactionEntity
import com.example.expensestracker.databinding.FragmentAddingBinding
import com.example.expensestracker.transactions.TransactionsFragment
import com.example.expensestracker.viewModels.AccountsViewModel
import com.example.expensestracker.viewModels.TransactionsViewModel

class FabAddingFragment(
    var accountEntity: AccountEntity?
) : Fragment() {

    private var binding: FragmentAddingBinding? = null
    private val viewModel: TransactionsViewModel by viewModels()
    private val accountViewModel: AccountsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddingBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSelectAccount = binding?.buttonSelectingAccount
        val buttonConfirm = binding?.buttonConfirmAdding

        buttonSelectAccount?.setOnClickListener { onButtonSelectAccountClickListener() }
        buttonConfirm?.setOnClickListener { onButtonConfirmClickListener() }
    }

    override fun onResume() {
        super.onResume()
        setTextInputLayout()
        if(accountEntity != null) {
            accountEntity?.image?.let { binding?.ivSelectedAccount?.setImageResource(it) }
            binding?.tvSelectedAccountName?.text = accountEntity!!.name.toString()
            binding?.tvSelectedAccountBalance?.text = accountEntity!!.balance.toString()
        }
    }

    private fun onButtonSelectAccountClickListener() {
        val fragment = SelectingAccountFragment()
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
    }

    private fun setTextInputLayout() {
        val categories = resources.getStringArray(R.array.categoriesArray)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, categories)
        binding?.autoCompleteTV?.setAdapter(arrayAdapter)
    }

    private fun onButtonConfirmClickListener() {
        val account = binding?.tvSelectedAccountName?.text.toString()
        val category = binding?.autoCompleteTV?.text.toString()
        val amount = binding?.etAmount?.text.toString()

        viewModel.addTransaction(TransactionEntity(0,category, account, Integer.parseInt(amount)))
        accountViewModel.updateAccount(AccountEntity(binding?.tvSelectedAccountName.toString(),
            binding?.ivSelectedAccount?.id, Integer.parseInt(amount)))
//        val selectedAccount = accountViewModel.getAccount(binding?.tvSelectedAccountName.toString())
//        var tempBalance = selectedAccount.balance
//        tempBalance = tempBalance?.minus(Integer.parseInt(amount))
//        selectedAccount.balance = tempBalance
//        accountViewModel.updateAccount(selectedAccount)
//
//        AccountUpdatingFragment(null, null).updateAccountBalance(
//            binding?.tvSelectedAccountName?.text.toString(), binding?.ivSelectedAccount?.id,
//            Integer.parseInt(binding?.etAmount?.text.toString())
//        )

        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, TransactionsFragment())
            transaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}