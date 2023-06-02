package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.app.api.ApiService
import com.example.app.model.Login
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val retrofit = Retrofit.Builder()
        .baseUrl("http://your-api-base-url.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


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
        val btnSignUp = findViewById<Button>(R.id.btnSignUp);
        btnSignUp.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        val intent = Intent(applicationContext, SignUpActivity::class.java)
        startActivity(intent)
    }

    /**
     * Login
     */
    private fun login() {
        val userName = findViewById<EditText>(R.id.username).text.toString();
        val password = findViewById<EditText>(R.id.password).text.toString();
        val login = Login(userName,password)
        val apiService = retrofit.create(ApiService::class.java)
        val response = apiService.login(login)
        if (response.isSuccessful){
            if(response.code() == 200){
                var user = response.body()
                val intent = Intent(applicationContext, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

}