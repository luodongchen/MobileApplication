
package com.example.homework
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class Login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val tvGoToRegister = findViewById<TextView>(R.id.tv_go_to_register)
        tvGoToRegister.setOnClickListener {

            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

}