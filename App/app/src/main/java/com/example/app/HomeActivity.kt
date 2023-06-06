package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initAction()
    }

    private fun initAction() {
        val btnFindBook = findViewById<Button>(R.id.btnListBook)
        btnFindBook.setOnClickListener {
            moveFindBook()
        }
        val btnBorrowBook = findViewById<Button>(R.id.btnBorrowbook)
        btnBorrowBook.setOnClickListener {
            moveBorrowBook()
        }
    }

    private fun moveBorrowBook() {
        TODO("Not yet implemented")
    }

    private fun moveFindBook() {
        TODO("Not yet implemented")
    }
}