package com.example.expensestracker.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expensestracker.R
import com.example.expensestracker.adapters.AccountsAdapter
import com.example.expensestracker.databinding.FragmentAccountsBinding
import com.example.expensestracker.databinding.FragmentCategoriesBinding
import org.koin.android.ext.android.bind

class AccountsFragment() : Fragment() {

    private var binding: FragmentAccountsBinding? = null
    private var accountsList: ArrayList<SingleAccount>? = null
    private var accountsAdapter: AccountsAdapter? = null

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
        val gridView = binding?.gvAccounts
        accountsList = ArrayList()
        accountsList = AccountsFactory.createBaseAccounts(accountsList!!)
        accountsAdapter = activity?.applicationContext?.let { AccountsAdapter(it,
            accountsList!!) }

        gridView?.adapter = accountsAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}