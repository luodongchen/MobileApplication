package com.example.homework

class CredentialsManager {


    fun isEmailValid(email: String): Boolean {

        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()
        return email.matches(emailRegex)
    }

    fun isPasswordValid(passwd: String): Boolean {
        // Define the rules for a valid password
        val minLength = 8
        val hasUppercase = passwd.any { it.isUpperCase() }
        val hasLowercase = passwd.any { it.isLowerCase() }
        val hasDigit = passwd.any { it.isDigit() }
        val hasSpecialChar = passwd.any { "!@#$%^&*()-_=+<>?".contains(it) }
        val isValidLength = passwd.length >= minLength

        // Check if all rules are satisfied
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar && isValidLength
    }

}