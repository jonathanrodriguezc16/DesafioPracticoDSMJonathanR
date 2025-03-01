package com.example.desafiopracticodsmjonathanr

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculadoraActivity : AppCompatActivity() {

    lateinit var etOperando1:EditText
    lateinit var etOperando2:EditText
    lateinit var spinnerOperaciones:Spinner
    lateinit var btnCalcular:Button
    lateinit var tvResultadoCalc:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)

        etOperando1 = findViewById(R.id.etOperando1)
        etOperando2 = findViewById(R.id.etOperando2)
        spinnerOperaciones = findViewById(R.id.spinnerOperaciones)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultadoCalc = findViewById(R.id.tvResultadoCalc)

        val operaciones = listOf("Suma", "Resta", "Multiplicación", "División", "Exponente", "Raíz Cuadrada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operaciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperaciones.adapter = adapter

        btnCalcular.setOnClickListener {
            calcular()
        }

    }

    private fun calcular() {
        // Validar que haya texto en Operando1
        if (etOperando1.text.isNullOrEmpty()) {
            tvResultadoCalc.text = "Ingresa el primer operando"
            return
        }

        // Operando 2 podría no ser necesario si hacemos raíz cuadrada
        val operacion = spinnerOperaciones.selectedItem.toString()
        val num1 = etOperando1.text.toString().toDouble()

        // Para raíz cuadrada, podemos ignorar el segundo operando
        val num2 = if (!etOperando2.text.isNullOrEmpty()) etOperando2.text.toString().toDouble() else 0.0

        val resultado = when (operacion) {
            "Suma" -> num1 + num2
            "Resta" -> num1 - num2
            "Multiplicación" -> num1 * num2
            "División" -> {
                if (num2 == 0.0) {
                    tvResultadoCalc.text = "Error: división entre cero."
                    return
                } else {
                    num1 / num2
                }
            }
            "Exponente" -> Math.pow(num1, num2)
            "Raíz Cuadrada" -> {
                // Para raíz cuadrada usaremos solo num1
                if (num1 < 0) {
                    tvResultadoCalc.text = "Error: raíz de número negativo."
                    return
                } else {
                    Math.sqrt(num1)
                }
            }
            else -> 0.0
        }

        tvResultadoCalc.text = "Resultado: $resultado"
    }
}