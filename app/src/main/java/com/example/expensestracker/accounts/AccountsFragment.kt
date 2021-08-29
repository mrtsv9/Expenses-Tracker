package com.example.expensestracker.accounts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.R
import com.example.expensestracker.adapters.AccountsAdapter
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.databinding.FragmentAccountsBinding
import com.example.expensestracker.viewModels.AccountsViewModel
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule

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

        val adapter = AccountsAdapter()
        binding?.rvAccounts?.layoutManager = LinearLayoutManager(binding?.root?.context,
            LinearLayoutManager.VERTICAL, false)
        binding?.rvAccounts?.adapter = adapter
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

    }

    private fun createBaseAccounts() {
        viewModel.addAccount(AccountsFactory.createCard())
        viewModel.addAccount(AccountsFactory.createWallet())
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}