package com.example.homework

import android.app.Application

class MyApp : Application() {
    val credentialManager: CredentialManager by lazy {
        CredentialManager()
    }
}
