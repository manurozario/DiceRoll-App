package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() { //the main activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }

        rollDice()

    }

    private fun rollDice() { //function for rolling dice
        val myDice = Dice(6) //declares a variable with 6 dice sides
        val diceRoll = myDice.roll() //a variable to call when we want to roll the dice


        val diceImage: ImageView = findViewById(R.id.imageView) //pull images of the dice
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        diceImage.setImageResource(drawableResource)

        val myDice2 = Dice(6) //2nd dice
        val diceRoll2 = myDice2.roll()

        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        diceImage2.setImageResource(drawableResource2)

        if(diceRoll == diceRoll2) { //print a toast messages when the value on both the dices match
            Toast.makeText(applicationContext, "Both dices rolled ${diceRoll}!", Toast.LENGTH_SHORT).show()
        }

    }

}

class Dice(private val sides: Int) { //class for the dice
    fun roll(): Int {
        return (1..sides).random() //generates a random number from 1 to the no. of sides of the dice
    }
}

