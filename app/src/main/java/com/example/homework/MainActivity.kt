package com.example.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load LoginFragment into the container
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, LoginFragment.newInstance("defaultParam1", "defaultParam2"))
            }
        }
    }
}
