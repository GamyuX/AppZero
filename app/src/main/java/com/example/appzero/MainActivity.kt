package com.example.appzero

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.appzero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonDolar.setOnClickListener {
            Escrever(0.8)
        }

        binding.buttonPeso.setOnClickListener {

        Escrever(10.2)
        }

        binding.buttonReal.setOnClickListener {
           Escrever(0.15)
        }
    }

    private fun Escrever(taxa: Double) {
            val euro = binding.editEuro.text.toString().trim()

            if (!euro.isEmpty()) {
                val resultado = euro.toDouble() / taxa;
                Toast.makeText(applicationContext,"${resultado}$",Toast.LENGTH_SHORT).show()
            }
    }
}