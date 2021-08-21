package com.example.expensestracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expensestracker.databinding.ActivityMainBinding
import org.koin.android.ext.android.bind

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavView.background = null
        binding.bottomNavView.menu.getItem(2).isEnabled = false
    }
}