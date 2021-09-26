package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    //shopping item lists has to be decleared in main
    val items: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ADD BUTTON
        val rollButton: Button = findViewById(R.id.button1)
        rollButton.setOnClickListener {
            addItem()
        }

    }

    private fun addItem() {

        // User's input of text
        val editText = findViewById<EditText>(R.id.editItem)
        val editTextValue = editText.text.toString() //the value user enters

        //add items
        items.add(editTextValue)
        val arrayAdapter: ArrayAdapter<*>

        var myListView = findViewById<ListView>(R.id.shoppinglist)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        myListView.adapter = arrayAdapter

    }

    private fun deleteItem() {
        val editText = findViewById<EditText>(R.id.editItem)
        val editTextValue = editText.text.toString()

        //
    }


}