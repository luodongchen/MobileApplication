package com.example.homework



import android.util.Patterns

class CredentialManager {


    private val credentials: MutableMap<String, String> = mutableMapOf()


    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    fun isPasswordStrong(password: String): Boolean {
        val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")
        return passwordPattern.matches(password)
    }


    fun isEmailAlreadyRegistered(email: String): Boolean {
        return credentials.containsKey(email)
    }

    fun getPassword(email: String): String? {
        return credentials[email]
    }


    fun register(email: String, password: String): Boolean {
        if (isEmailAlreadyRegistered(email)) {
            return false
        }
        credentials[email] = password
        return true
    }
}
