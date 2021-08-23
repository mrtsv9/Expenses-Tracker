package com.example.expensestracker.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expensestracker.databinding.FragmentAccountsBinding
import com.example.expensestracker.databinding.FragmentCategoriesBinding
import com.example.expensestracker.databinding.FragmentProfileBinding
import com.example.expensestracker.databinding.FragmentTransactionsBinding

class ProfileFragment() : Fragment() {

    private var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}