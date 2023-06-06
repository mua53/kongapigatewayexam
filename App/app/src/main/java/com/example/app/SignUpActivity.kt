package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.app.model.Login
import com.example.app.model.SignUp
import com.example.app.model.User
import com.example.app.storage.SharedPrefManager
import com.example.cspart.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initAction()
    }

    private fun initAction(){
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            signUp()
        }
    }

    private fun signUp(){
        val usename = findViewById<EditText>(R.id.username_signup).text.toString()
        val password = findViewById<EditText>(R.id.password_signup).text.toString()
        val fullname = findViewById<EditText>(R.id.name_signup).text.toString()
        val address = findViewById<EditText>(R.id.address_signup).text.toString()
        val phone = findViewById<EditText>(R.id.phone_signup).text.toString()
        var data = SignUp(
            username = usename,
            password = password,
            fullname = fullname,
            address = address,
            phone = phone,
            type = 1
        )
        val callSignUp = RetrofitClient.instance.signup(data)
        callSignUp.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    if (response.code() == 200){
                        val intent = Intent(applicationContext, Login::class.java)
                        startActivity(intent)
                    } else if (response.code() == 409) {
                        Toast.makeText(applicationContext, "Tài khoản đã tồn tại", Toast.LENGTH_LONG).show()
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