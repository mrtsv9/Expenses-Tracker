package com.example.expensestracker.fab_adding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expensestracker.databinding.FragmentAddingBinding
import org.koin.android.ext.android.bind

class FabAddingFragment() : Fragment() {

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
        val button = binding?.buttonConfirm
        button?.setOnClickListener { onClickListener() }
    }

    private fun onClickListener() {

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}