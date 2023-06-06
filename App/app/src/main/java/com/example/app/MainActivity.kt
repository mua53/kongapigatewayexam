package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.app.model.Login
import com.example.app.model.User
import com.example.app.storage.SharedPrefManager
import com.example.cspart.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val btnSignUp = findViewById<Button>(R.id.btnSignUp);
        btnSignUp.setOnClickListener {
            signUp()
        }
    }

    /**
    * Chuyển sang màn hình sign up
    */
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
        val dataBody = Login(userName,password)
        val callLogin = RetrofitClient.instance.login(dataBody)
        callLogin.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    val userId = loginResponse?._id
                    if (userId != null) {
                        SharedPrefManager.saveString(applicationContext, "userId", userId)
                        val intent = Intent(applicationContext, HomeActivity::class.java)
                        startActivity(intent)
                    }
                } else {
                    // Handle error response
                    val errorBody = response.errorBody()?.string()
                    Toast.makeText(applicationContext, errorBody, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext,
                    "Có lỗi xảy ra",
                    Toast.LENGTH_LONG).show()
                // Handle network failure
            }
        })

    }

}