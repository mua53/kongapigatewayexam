package com.example.app.api

import com.example.app.model.Book
import com.example.app.model.Login
import com.example.app.model.SignUp
import com.example.app.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("/user/login")
    fun login(@Body login: Login): Call<User>

    @POST("/user/signup")
    fun signup(@Body signUp: SignUp): Call<User>

    @GET("/books/findbook")
    fun findBook(@Query("name") name:String): Call<List<Book>>

    @GET("/book/get-list-borrow-book/{userId}")
    fun findBookBorrow(@Path("userId") userID: String): Call<List<Book>>
}