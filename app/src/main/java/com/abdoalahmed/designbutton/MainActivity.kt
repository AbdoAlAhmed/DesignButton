package com.abdoalahmed.designbutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button =findViewById<DesignButton>(R.id.designButton)
        button.setOnClickListener {
                Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
            button.changeButtonState(ButtonState.Clicked)
        }

    }
}