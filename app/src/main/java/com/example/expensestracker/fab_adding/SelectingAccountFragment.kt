package com.example.expensestracker.fab_adding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.adapters.AccountsAdapter
import androidx.lifecycle.Observer
import com.example.expensestracker.R
import com.example.expensestracker.accounts.AccountsFactory
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.databinding.FragmentAccountSelectingBinding
import com.example.expensestracker.viewModels.AccountsViewModel


class SelectingAccountFragment : Fragment() {

    private var binding: FragmentAccountSelectingBinding? = null
    private val viewModel: AccountsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountSelectingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AccountsAdapter() { clickListener(it) }

        binding?.rvSelectingAccounts?.layoutManager = LinearLayoutManager(binding?.root?.context,
            LinearLayoutManager.VERTICAL, false)
        binding?.rvSelectingAccounts?.adapter = adapter
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it, null)
        })
        viewModel.addAccount(AccountsFactory.createCard())



    }

    private fun clickListener(accountEntity: AccountEntity) {
        val fragment = FabAddingFragment(accountEntity)
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
    }

    companion object {
        var name = ""
        var image = 0
        var balance = 0
    }

}