package com.krillinator.listviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ArrayAdapter - String
        val arrayAdapter: ArrayAdapter<String>

        // Array
        var fruits = arrayOf("Bananas", "Apples", "Berries", "Tomatoes")

        // ListView from XML
        var productList = findViewById<ListView>(R.id.products)

        // Connection
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fruits)
        productList.adapter = arrayAdapter

        productList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id -> // value of item that is clicked
                val itemValue = productList.getItemAtPosition(position) as String

                // Toast the values
                Toast.makeText(
                    applicationContext,
                    "Position :$position\nItem Value : $itemValue", Toast.LENGTH_LONG
                )
                    .show()
            }
    }
}

