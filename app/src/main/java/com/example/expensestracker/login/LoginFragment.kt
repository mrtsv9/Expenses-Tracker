package com.example.expensestracker.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentLoginBinding
import com.example.expensestracker.login.DataValidation.validateData
import com.example.expensestracker.main.MainFragment

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
        buttonConfirm?.setOnClickListener { clickListener(buttonConfirm) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun clickListener(view: View) {
        if(validateData(binding!!.loginLayout, binding!!.login,
            binding!!.passwordLayout, binding!!.password)) {
            (activity as? MainActivity)?.replaceFragment(MainFragment())
        }
        else {
            Toast.makeText(activity, resources.getString(R.string.incorrect_value),
                Toast.LENGTH_SHORT).show()
        }
    }
}