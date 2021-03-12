package com.example.calcularimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.calcularimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcButton.setOnClickListener {
            val keyboard: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
            calcImc()
        }
    }

    private fun cleanValues() {
        binding.altura.text = null
        binding.peso.text = null
    }

    private fun verifyValues(): Boolean {
        if (binding.altura.text.toString().isBlank() || binding.peso.text.toString().isBlank()) {
            return false
        }
        return true
    }

    private fun calcImc() {
        if (!verifyValues()) {
            Log.w("","Aqui em verificar")
            Toast.makeText(this, "Digite seu peso/altura", Toast.LENGTH_SHORT).show()
        }else{
            Log.w("","Direto no codigo")
            val altura = binding.altura.text.toString().toDouble()
            val peso = binding.peso.text.toString().toDouble()
            val imc = peso/(altura * altura)
            Toast.makeText(this, "IMC: $imc", Toast.LENGTH_LONG).show()
            cleanValues()
        }
    }
}