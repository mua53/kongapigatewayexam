package com.example.app.api

import com.example.app.model.Login
import com.example.app.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/user/login")
    fun login(@Body login: Login): Response<User>
}