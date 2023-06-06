package com.example.app.model

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.app.R

class AdapterMaterial(context: Context, layoutInt: Int, var arrayList: List<Book>) : ArrayAdapter<Book>(context,
                      R.layout.material_detail, arrayList) {



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.material_detail,null)

        val name: TextView = view.findViewById(R.id.txtBookName)
        val code: TextView = view.findViewById(R.id.txtAuth)
        var total: TextView = view.findViewById(R.id.txtAddress)
        var no: TextView = view.findViewById(R.id.txtNo)

        name.text = arrayList[position].name
        code.text = arrayList[position].author
        no.text = position.toString()
        total.text = arrayList[position].location

        return view
    }
}