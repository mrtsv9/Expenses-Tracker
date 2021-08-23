package com.example.expensestracker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.accounts.AccountsFragment
import com.example.expensestracker.categories.CategoriesFragment
import com.example.expensestracker.databinding.FragmentMainBinding
import com.example.expensestracker.fab_adding.FabAddingFragment
import com.example.expensestracker.profile.ProfileFragment
import com.example.expensestracker.settings.SettingsFragment
import com.example.expensestracker.transactions.TransactionsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment() : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var binding: FragmentMainBinding? = null
    private var navView: BottomNavigationView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fixBottomNavView()
        whenFirstTimeOpened()

        navView = binding?.bottomNavView
        val fab = binding?.fab
        val settings = binding?.ivSettings

        navView?.setOnNavigationItemSelectedListener(this)
        fab?.setOnClickListener { onFabClicked() }
        settings?.setOnClickListener { onSettingsClicked() }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun fixBottomNavView() {
        navView = binding?.bottomNavView
        navView?.background = null
        navView?.menu?.getItem(2)?.isEnabled = false
    }

    private fun whenFirstTimeOpened() {
        val container = binding?.container
        navView = binding?.bottomNavView
        childFragmentManager.beginTransaction()
            .replace(container?.id!!, AccountsFragment())
            .addToBackStack(null)
            .commit()
        binding?.tvTitle?.text =  navView?.menu?.getItem(0)?.title
    }

    private fun onFabClicked() {
        childFragmentManager.beginTransaction()
            .replace(binding?.container?.id!!, FabAddingFragment())
            .commit()
        binding?.tvTitle?.text = resources.getString(R.string.new_operation)
    }

    private fun onSettingsClicked() {
        (activity as? MainActivity)?.replaceFragment(SettingsFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        navView = binding?.bottomNavView
        val container = binding?.container
        var id = item.itemId
//        Navigation().updateFragment(navView, item.itemId, binding?.container)
        when (id) {
            2131230956 -> { childFragmentManager.beginTransaction()
                .replace(container?.id!!, AccountsFragment())
                .addToBackStack(null)
                .commit()
                binding?.tvTitle?.text =  item.title }
            2131230957 -> { childFragmentManager.beginTransaction()
                .replace(container?.id!!, CategoriesFragment())
                .addToBackStack(null)
                .commit()
                binding?.tvTitle?.text =  item.title }
            2131230959 -> { childFragmentManager.beginTransaction()
                .replace(container?.id!!, TransactionsFragment())
                .addToBackStack(null)
                .commit()
                binding?.tvTitle?.text =  item.title }
            2131230958 -> { childFragmentManager.beginTransaction()
                .replace(container?.id!!, ProfileFragment())
                .addToBackStack(null)
                .commit()
                binding?.tvTitle?.text =  item.title }
        }
        return true
    }

}