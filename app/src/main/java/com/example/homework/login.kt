

package com.example.homework
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.text.TextUtils
import android.widget.CheckBox


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        val emailEditText = findViewById<EditText>(R.id.et_email)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val loginButton = findViewById<Button>(R.id.btn_login)
        val registerTextView = findViewById<TextView>(R.id.tv_go_to_register)
        val forgotPasswordTextView = findViewById<TextView>(R.id.tv_forgot_password)
        val rememberMeCheckBox = findViewById<CheckBox>(R.id.checkbox_remember_me)

        // Handle Login Button Click
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validate inputs
            if (validateInputs(email, password)) {
                // Perform login logic (e.g., call API or check credentials)
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // Navigate to next activity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        // Navigate to Register Screen
        registerTextView.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        // Handle Forgot Password
        forgotPasswordTextView.setOnClickListener {
            Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
            // Navigate to Forgot Password Screen (if applicable)
        }
    }

    // Function to validate inputs
    private fun validateInputs(email: String, password: String): Boolean {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.length < 4) {
            Toast.makeText(this, "Password must be at least 4 characters long", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
