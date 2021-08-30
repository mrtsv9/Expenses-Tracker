package com.example.expensestracker.fab_adding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.expensestracker.R
import com.example.expensestracker.categories.CategoriesFragment
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.databinding.FragmentAddingBinding

class FabAddingFragment(
    var accountEntity: AccountEntity?
) : Fragment() {

    private var binding: FragmentAddingBinding? = null

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
        val buttonSelectCategory = binding?.buttonSelectingCategory
        val buttonConfirm = binding?.buttonConfirmAdding

        buttonSelectAccount?.setOnClickListener { onButtonSelectAccountClickListener() }
        buttonSelectCategory?.setOnClickListener { onButtonSelectCategoryClickListener() }
        buttonConfirm?.setOnClickListener { onButtonConfirmClickListener() }
    }

    override fun onResume() {
        super.onResume()
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

    private fun onButtonSelectCategoryClickListener() {
        val fragment = CategoriesFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
    }


    private fun onButtonConfirmClickListener() {

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}