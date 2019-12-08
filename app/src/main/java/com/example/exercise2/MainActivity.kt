package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculateBMI()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            resetBMI()
        }
    }
    private fun calculateBMI() {
        val height = findViewById<EditText>(R.id.editTextHeight)
        val cm: Double = height.text.toString().toDouble()/100
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val kg: Double = weight.text.toString().toDouble()

        val result:Double= kg/ cm.pow(2.0)
        val image = findViewById<ImageView>(R.id.imageViewProfile)
        image.setImageResource(R.drawable.empty)

        when {
            result < 18.5 -> {
                image.setImageResource(R.drawable.under)
            }
            result in 18.5..24.9 -> {
                image.setImageResource(R.drawable.normal)
            }
            result >= 25 -> {
                image.setImageResource(R.drawable.over)
            }
        }
        val viewResult = findViewById<TextView>(R.id.textViewBMI)
        viewResult.text = "BMI : $result"

    }
    private fun resetBMI(){
        val height = findViewById<EditText>(R.id.editTextHeight)
        height.setText("")
        val weight = findViewById<EditText>(R.id.editTextWeight)
        weight.setText("")
        val image = findViewById<ImageView>(R.id.imageViewProfile)
        image.setImageResource(R.drawable.empty)
        val viewResult = findViewById<TextView>(R.id.textViewBMI)
        viewResult.text = "BMI : "
}
}
