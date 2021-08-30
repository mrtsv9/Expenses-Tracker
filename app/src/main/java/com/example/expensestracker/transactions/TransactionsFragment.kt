package com.example.expensestracker.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.adapters.TransactionsAdapter
import com.example.expensestracker.databinding.FragmentAccountsBinding
import com.example.expensestracker.databinding.FragmentCategoriesBinding
import com.example.expensestracker.databinding.FragmentTransactionsBinding
import com.example.expensestracker.viewModels.AccountsViewModel
import com.example.expensestracker.viewModels.TransactionsViewModel
import kotlinx.coroutines.runInterruptible

class TransactionsFragment() : Fragment() {

    private var binding: FragmentTransactionsBinding? = null
    private val viewModel: TransactionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TransactionsAdapter()
        binding?.rvTransactions?.layoutManager = LinearLayoutManager(binding?.root?.context,
            LinearLayoutManager.VERTICAL, false)
        binding?.rvTransactions?.adapter = adapter
        viewModel.readAllData.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}