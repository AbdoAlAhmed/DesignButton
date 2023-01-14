package com.abdoalahmed.designbutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.abdoalahmed.designbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var viewModel = MainActivityViewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        // set button state
        binding.designButton.setOnClickListener {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
            binding.designButton.changeButtonState(ButtonState.Clicked)
        }


    }

}