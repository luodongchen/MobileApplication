package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class LoginFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private val credentialManager: CredentialManager by lazy {
        CredentialManager()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        emailEditText = view.findViewById(R.id.et_email)
        passwordEditText = view.findViewById(R.id.et_password)
        loginButton = view.findViewById(R.id.btn_login)
        registerTextView = view.findViewById(R.id.tv_go_to_register)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        loginButton.setOnClickListener {
            handleLogin()
        }




        val button: TextView = view.findViewById(R.id.tv_go_to_register)
        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegisterFragment.newInstance("param1", "param2"))
                .addToBackStack(null)
                .commit()
        }

        return view
    }



    private fun handleLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        if (!sharedViewModel.isEmailValid(email)) {
            Toast.makeText(context, "Invalid email format", Toast.LENGTH_SHORT).show()
            return
        }

        if (sharedViewModel.isEmailAlreadyRegistered(email)) {
            if (password == sharedViewModel.getPW(email)) {
                Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
                navigateToHomePage()
            } else {
                Toast.makeText(context, "Invalid password", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Email not registered", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToHomePage() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentB.newInstance("param1", "param2"))
            .addToBackStack(null)
            .commit()
        Toast.makeText(context, "Welcome to the app!", Toast.LENGTH_SHORT).show()
    }


    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"



        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
