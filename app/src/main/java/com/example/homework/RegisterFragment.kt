package com.example.homework



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class RegisterFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(RegisterFragment.ARG_PARAM1)
            param2 = it.getString(RegisterFragment.ARG_PARAM2)
        }
    }

    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var goToLoginTextView: TextView

    private val credentialManager: CredentialManager by lazy {
        CredentialManager()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)


        usernameEditText = view.findViewById(R.id.et_username)
        emailEditText = view.findViewById(R.id.et_email)
        passwordEditText = view.findViewById(R.id.et_password)
        registerButton = view.findViewById(R.id.btn_register)
        goToLoginTextView = view.findViewById(R.id.tv_go_to_login)


        registerButton.setOnClickListener {
            handleRegistration()
        }


        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)





        goToLoginTextView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment.newInstance("param1","param2"))
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    private fun handleRegistration() {
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

        /*if (!sharedViewModel.isPasswordStrong(password)) {
            Toast.makeText(context, "Password must be at least 8 characters, include uppercase, lowercase, and a number", Toast.LENGTH_SHORT).show()
            return
        }*/

        if (sharedViewModel.register(email, password)) {
            Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
            navigateToLoginPage()
        } else {
            Toast.makeText(context, "Email already registered", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToLoginPage() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoginFragment.newInstance("param1", "param2"))
            .addToBackStack(null)
            .commit()
        Toast.makeText(context, "Welcome to the app!", Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String = "", param2: String = "") =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
