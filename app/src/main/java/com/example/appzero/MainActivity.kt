package com.example.appzero

import android.os.Bundle
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

        binding.buttonConverter.setOnClickListener {

            val real = binding.editReal.text.toString().trim()
            real.isNotEmpty().let {
                when (binding.radioGroup.checkedRadioButtonId) {
                    binding.radioButtonD.id -> binding.textDolar.text = getDolar(real.toDouble())
                    binding.radioButtonY.id -> binding.textDolar.text = getYen(real.toDouble())
                    binding.radioButtonE.id -> binding.textDolar.text = getEuro(real.toDouble())
                }
            }
        }
    }
    private fun getDolar(value: Double): String {
        val dolares = value / 6.21
        return "US\$ ${String.format("%.2f", dolares)}"
    }

    private fun getYen(value: Double): String {
        val dolares = value * 25.45
        return "JPY\$ ${String.format("%.2f", dolares)}"
    }

    private fun getEuro(value: Double): String {
        val dolares = value / 6.47
        return "EUR\$ ${String.format("%.2f", dolares)}"
    }

}