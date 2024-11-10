package com.example.homework


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Patterns


class Register : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etFullName = findViewById<EditText>(R.id.et_username)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPhone = findViewById<EditText>(R.id.et_number)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnContinue = findViewById<Button>(R.id.btn_register)

        btnContinue.setOnClickListener {
            val fullName = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Registration data submitted", Toast.LENGTH_SHORT).show()

            }
        }

        val tvGoToLogin = findViewById<TextView>(R.id.tv_go_to_login)
        tvGoToLogin.setOnClickListener {

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }



}
