package com.example.homework

import androidx.lifecycle.ViewModel



class SharedViewModel : ViewModel() {


    private val credentialManager = CredentialManager()


    fun isEmailValid(email: String): Boolean {
        return credentialManager.isEmailValid(email)
    }

    fun isPasswordStrong(password: String): Boolean {
        return credentialManager.isPasswordStrong(password)
    }

    fun isEmailAlreadyRegistered(email: String): Boolean {
        return credentialManager.isEmailAlreadyRegistered(email)
    }

    fun register(email: String, password: String): Boolean {
        return credentialManager.register(email, password)
    }

    fun getPW(email: String): String? {
        return credentialManager.getPassword(email)
    }
}
