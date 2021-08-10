package com.example.memorygame
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

    class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button3x4 : Button = findViewById(R.id.mainButtonThreeCrossFour)
        val button4x4 : Button = findViewById(R.id.mainButtonFourCrossFour)
        val button4x5 : Button = findViewById(R.id.mainButtonFourCrossFive)
        val button5x2 : Button = findViewById(R.id.mainButtonFiveCrossTwo)

        button3x4.setOnClickListener {
            val i = Intent(this, GridThreeCrossFour::class.java)
            startActivity(i)
        }
        button4x4.setOnClickListener {
            val i = Intent(this, GridFourCrossFour::class.java)
            startActivity(i)
        }
        button4x5.setOnClickListener {
            val i = Intent(this, GridFourCrossFive::class.java)
            startActivity(i)
        }
        button5x2.setOnClickListener {
            val i = Intent(this, GridFiveCrossTwo::class.java)
            startActivity(i)
        }
    }

}