package com.example.expensestracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.expensestracker.databinding.ActivityMainBinding
import com.example.expensestracker.login.LoginFragment
import com.example.expensestracker.main.MainFragment
import org.koin.android.ext.android.bind

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragment()
    }

    private fun showFragment() {
        supportFragmentManager.beginTransaction()
            .add(binding.navHostFragment.id, LoginFragment())
            .addToBackStack(null)
            .commit()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.navHostFragment.id, fragment)
            .commit()
    }
}