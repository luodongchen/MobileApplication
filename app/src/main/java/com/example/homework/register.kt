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
import android.util.Patterns
import android.widget.CheckBox



class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val usernameEditText = findViewById<EditText>(R.id.et_username)
        val emailEditText = findViewById<EditText>(R.id.et_email)
        val phoneEditText = findViewById<EditText>(R.id.et_number)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val termsCheckBox = findViewById<CheckBox>(R.id.checkbox_term)
        val registerButton = findViewById<Button>(R.id.btn_register)
        val loginTextView = findViewById<TextView>(R.id.tv_go_to_login)


        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()


            if (validateInputs(username, email, phone, password, termsCheckBox.isChecked)) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }
        }


        loginTextView.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }


<<<<<<< HEAD


=======
    // Function to validate inputs
>>>>>>> 2892c93f440223dd3b66ed3d6d89e3161d25c793
    private fun validateInputs(username: String, email: String, phone: String, password: String, termsAccepted: Boolean): Boolean {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please enter your full name", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(phone) || phone.length != 10 || !phone.all { it.isDigit() }) {
            Toast.makeText(this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(password) || password.length < 8) {
            Toast.makeText(this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!termsAccepted) {
            Toast.makeText(this, "You must agree to the Terms and Conditions", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}

