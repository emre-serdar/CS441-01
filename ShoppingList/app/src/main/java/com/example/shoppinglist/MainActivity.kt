package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // User's input of text

        val textView : TextView = findViewById(R.id.textView)

        //ADD BUTTON
        val rollButton: Button = findViewById(R.id.button1)
        rollButton.setOnClickListener {
            addItem()
        }

        val myRecyclerView: RecyclerView = findViewById(R.id.recyclerView)

        //Layout
        myRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //adapter
        myRecyclerView.adapter = Adapter





    }

    private fun addItem() {
        // Take the textview which users enters, add it to dynamic list of RecylerView

        TODO("Not yet implemented")
    }
}