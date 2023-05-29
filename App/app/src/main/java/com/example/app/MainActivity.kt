package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAction()
    }

    /**
     * Khởi tạo action
     *
     */
    private fun initAction() {
        val btnLogin = findViewById<Button>(R.id.btnLogin);
        btnLogin.setOnClickListener {
            login()
        }
    }

    /**
     * Login
     */
    private fun login() {

    }

}