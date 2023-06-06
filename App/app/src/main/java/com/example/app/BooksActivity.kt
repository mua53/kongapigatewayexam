package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.app.model.AdapterMaterial
import com.example.app.model.Book
import com.example.app.model.User
import com.example.app.storage.SharedPrefManager
import com.example.cspart.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
        bindingData("")
        initSearchBar()
    }

    private fun initSearchBar() {
        var searchView = findViewById<SearchView>(R.id.findBook)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                bindingData(query)
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

    }




    private fun bindingData(nameBook: String) {
        var listView = findViewById<ListView>(R.id.lstBook)
        RetrofitClient.instance.findBook(nameBook).enqueue(
            object : Callback<List<Book>> {
                override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                    if (response.isSuccessful){
                        val lst_book = response.body()
                        listView.adapter = lst_book?.let {
                            AdapterMaterial(
                                applicationContext,
                                R.layout.material_detail,
                                lst_book
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                    Toast.makeText(applicationContext,
                        "Có lỗi xảy ra",
                        Toast.LENGTH_LONG).show()
                }
            }
        )
    }
}