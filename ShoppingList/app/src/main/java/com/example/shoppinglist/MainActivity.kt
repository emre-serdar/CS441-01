package com.example.shoppinglist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    //shopping item lists has to be decleared in main
    val items: MutableList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ADD BUTTON
        val addButton: Button = findViewById(R.id.button1)



        addButton.setOnClickListener {

            val editText = findViewById<EditText>(R.id.editItem)

            val editTextValue = editText.text.toString()
            //If item is already inside
            if(editTextValue in items){
                    Toast.makeText(applicationContext, "Item already exist on the list!", Toast.LENGTH_LONG).show()
            }
            else {
                addItem()
            }

        }
        //Delete Button
        val deleteButton: Button = findViewById(R.id.button2)

        deleteButton.setOnClickListener{
            val editText = findViewById<EditText>(R.id.editItem)

            val editTextValue = editText.text.toString()
            //If item is already inside
            if (!(editTextValue in items)){
                Toast.makeText(applicationContext, "You cannot delete and item that doesn't exist!", Toast.LENGTH_LONG).show()
            }
            else {
                deleteItem()
            }


        }
    }

    private fun addItem() {

        // User's input of text
        //the value user enters
        val editText = findViewById<EditText>(R.id.editItem)
        val editTextValue = editText.text.toString()
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

        items.remove(editTextValue)

        val arrayAdapter: ArrayAdapter<*>

        var myListView = findViewById<ListView>(R.id.shoppinglist)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        myListView.adapter = arrayAdapter
        //
    }


}