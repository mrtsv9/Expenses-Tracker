package com.example.expensestracker.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.R
import com.example.expensestracker.adapters.AccountsAdapter
import com.example.expensestracker.databinding.FragmentAccountsBinding
import com.example.expensestracker.viewModels.AccountsViewModel

class AccountsFragment : Fragment() {

    private var binding: FragmentAccountsBinding? = null
    private val viewModel: AccountsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createBaseAccounts()
        val buttonAdd = binding?.ibAddAccount

        val adapter = AccountsAdapter() {}
        binding?.rvAccounts?.layoutManager = LinearLayoutManager(binding?.root?.context,
            LinearLayoutManager.VERTICAL, false)
        binding?.rvAccounts?.adapter = adapter
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it, binding?.tvBalance)
        })

        buttonAdd?.setOnClickListener { onClickListener() }

    }

    private fun createBaseAccounts() {
        viewModel.addAccount(AccountsFactory.createCard())
        viewModel.addAccount(AccountsFactory.createWallet())
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun onClickListener() {
        val accountAddingFragment = AccountAddingFragment(binding?.tvBalance)
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, accountAddingFragment)
            transaction.commit()
    }

}