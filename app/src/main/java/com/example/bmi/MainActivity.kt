package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calbtn = findViewById<Button>(R.id.buttonCalculate)

        calbtn.setOnClickListener{
            calculateBMI()
        }

        val rstbtn = findViewById<Button>(R.id.buttonReset)

        rstbtn.setOnClickListener{
            editTextWeight.text = null
            editTextHeight.text = null

        }

    }

    private fun  calculateBMI(){
        val weight : Float = editTextWeight.text.toString().toFloat()
        val height : Float = editTextHeight.text.toString().toFloat()/100
        val result  : Float = weight / (height*height)
        val bmi : String = String.format("%.2f", result)

        if (result < 18.5){
            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.under)
            textViewBMI.text = "BMI:" +  bmi
        }
         else if (result >= 18.5 && result <= 24.9){

            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.normal)
            textViewBMI.text = "BMI:" +  bmi
        }else if (result > 25){
            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.over)
        }else{
            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.empty)
        }
    }
}
