package com.example.app.model

data class User(
    var _id: String,
    var username: String,
    var fullname: String?,
    var address: String?,
    var phone: String?,
    var type: Int?
)
