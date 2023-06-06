package com.example.app

import android.content.Intent
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
        val intent = Intent(applicationContext, BooksActivity::class.java)
        startActivity(intent)
    }

    private fun moveFindBook() {
        val intent = Intent(applicationContext, BooksActivity::class.java)
        startActivity(intent)
    }
}