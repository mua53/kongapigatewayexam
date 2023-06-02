package com.example.app.model

data class Book(
    var _id:String,
    var name:String,
    var type_book: String,
    var author:String,
    var release_year: Int,
    var location: String,
    var borrower: String?,
    var nation: String,
    var code: String
)
