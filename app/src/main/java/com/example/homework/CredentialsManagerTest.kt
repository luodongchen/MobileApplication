package com.example.homework


import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {


    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("")

        assertEquals(false, isEmailValid)
    }


    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("invalid-email")

        assertEquals(false, isEmailValid)
    }


    @Test
    fun givenProperEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("user@example.com")

        assertEquals(true, isEmailValid)
    }


    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("")

        assertEquals(false, isPasswordValid)
    }


    @Test
    fun givenFilledPassword_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("StrongPassword123")

        assertEquals(true, isPasswordValid)
    }
}

