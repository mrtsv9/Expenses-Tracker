package com.example.expensestracker.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.database.UserEntity
import com.example.expensestracker.databinding.FragmentLoginBinding
import com.example.expensestracker.login.DataValidation.validateData
import com.example.expensestracker.main.MainFragment
import com.example.expensestracker.viewModels.LoginViewModel

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null
    private val viewModel: LoginViewModel by viewModels()

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
                insertDataToDatabase()
                (activity as? MainActivity)?.replaceFragment(MainFragment())
        }
        else {
            Toast.makeText(activity, resources.getString(R.string.incorrect_value),
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertDataToDatabase() {
        val login = binding?.login?.text.toString()
        val password = binding?.password?.text.toString()

        // Create User Object
        val user = UserEntity(login, password)

        // Add a data to db
        viewModel.addUser(user)
    }
}