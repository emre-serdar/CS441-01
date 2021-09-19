package com.example.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flipButton: Button = findViewById(R.id.button)
        flipButton.setOnClickListener {
            flipDice()
        }
    }

    private fun flipDice() {
        val coin = Coin()
        val coinFlip = coin.flip()

        val resultTextView: TextView  = findViewById(R.id.textView)
        resultTextView.text = coinFlip
    }
}

class Coin{
    fun flip(): String {
        // lets represent 1 as Heads and 2 as Tails
        val coin = (1..2).random()
        if ( coin == 1){
            return "HEADS"
        }
        return "TAILS"
    }

}