package com.example.rat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun sil(num: Int): Long {
            return if(num <= 1 ) 1
            else num * sil(num-1 )
        }

        var x = 1
        // Left button listener
        findViewById<Button>(R.id.buttonLeft).setOnClickListener {
            when(x) {
                1 -> {
                    x = 3
                    findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.zdj3)
                    findViewById<TextView>(R.id.currentImageText).text = x.toString()
                    Log.i("Current image: ", x.toString())
                }
                2 -> {
                    x--
                    findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.zdj1)
                    findViewById<TextView>(R.id.currentImageText).text = x.toString()
                    Log.i("Current image: ", x.toString())
                }
                3 -> {
                    x--
                    findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.zdj2)
                    findViewById<TextView>(R.id.currentImageText).text = x.toString()
                    Log.i("Current image: ", x.toString())
                }
            }
        }

        // Right button listener
        findViewById<Button>(R.id.buttonRight).setOnClickListener {
            when(x) {
                1 -> {
                    x++
                    findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.zdj2)
                    findViewById<TextView>(R.id.currentImageText).text = x.toString()
                    Log.i("Current image: ", x.toString())
                }
                2 -> {
                    x++
                    findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.zdj3)
                    findViewById<TextView>(R.id.currentImageText).text = x.toString()
                    Log.i("Current image: ", x.toString())
                }
                3 -> {
                    x = 1
                    findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.zdj1)
                    findViewById<TextView>(R.id.currentImageText).text = x.toString()
                    Log.i("Current image: ", x.toString())
                }
            }
        }

        // Factorial button listener
        findViewById<Button>(R.id.buttonSilnia).setOnClickListener {

            // Check if input is int
            try {
                val num = findViewById<EditText>(R.id.inputSilnia).text.toString().toInt()
                // Check if number is in range
                if (num in 1..10) {
                    findViewById<TextView>(R.id.textSilnia).text = sil(num).toString()
                }
                // If not, show error message
                else {
                    findViewById<TextView>(R.id.textSilnia).text = "Limit: 1-10"
                }
            // If the input is not int
            } catch (e: Exception) {
                findViewById<TextView>(R.id.textSilnia).text = "Nie jest liczbą"
            }
        }


    }
}