package com.example.homework

class CredentialsManager {


    fun isEmailValid(email: String): Boolean {

        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()
        return email.matches(emailRegex)
    }
}
