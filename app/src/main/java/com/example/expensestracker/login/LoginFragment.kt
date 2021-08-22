package com.example.expensestracker.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.expensestracker.MainActivity
import com.example.expensestracker.databinding.FragmentLoginBinding
import org.koin.android.ext.android.bind

class LoginFragment() : Fragment() {

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonConfirm: Button? = binding?.buttonConfirm
        buttonConfirm?.setOnClickListener{clickListener(buttonConfirm)}

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun clickListener(view: View) {
        (activity as? MainActivity)?.replaceFragment()
    }
}