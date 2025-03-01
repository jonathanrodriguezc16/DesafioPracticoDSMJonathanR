package com.example.desafiopracticodsmjonathanr

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PromedioActivity : AppCompatActivity() {

    lateinit var etNombre:EditText
    lateinit var etNota1:EditText
    lateinit var etNota2:EditText
    lateinit var etNota3:EditText
    lateinit var etNota4:EditText
    lateinit var etNota5:EditText
    lateinit var btnCalcular:Button
    lateinit var tvResultado:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_promedio)


        etNombre = findViewById(R.id.etNombre)
        etNota1 = findViewById(R.id.etNota1)
        etNota2 = findViewById(R.id.etNota2)
        etNota3 = findViewById(R.id.etNota3)
        etNota4 = findViewById(R.id.etNota4)
        etNota5 = findViewById(R.id.etNota5)
        btnCalcular = findViewById(R.id.btnCalcularPromedio)
        tvResultado = findViewById(R.id.tvResultado)
        btnCalcular.setOnClickListener {
            calcularPromedio()

        }
    }
    private fun calcularPromedio() {
        val nombre = etNombre.text.toString()


        if (etNota1.text.isNullOrEmpty() ||
            etNota2.text.isNullOrEmpty() ||
            etNota3.text.isNullOrEmpty() ||
            etNota4.text.isNullOrEmpty() ||
            etNota5.text.isNullOrEmpty()) {
            tvResultado.text = "Por favor, llena todas las notas."
            return
        }


        val nota1 = etNota1.text.toString().toDouble()
        val nota2 = etNota2.text.toString().toDouble()
        val nota3 = etNota3.text.toString().toDouble()
        val nota4 = etNota4.text.toString().toDouble()
        val nota5 = etNota5.text.toString().toDouble()

        // Validar rango 0-10
        if (nota1 !in 0.0..10.0 ||
            nota2 !in 0.0..10.0 ||
            nota3 !in 0.0..10.0 ||
            nota4 !in 0.0..10.0 ||
            nota5 !in 0.0..10.0) {
            tvResultado.text = "Las notas deben estar entre 0 y 10."
            return
        }


        val promedio = (nota1 * 0.15) + (nota2 * 0.15) + (nota3 * 0.20) + (nota4 * 0.25) + (nota5 * 0.25)


        val estado = if (promedio >= 6.0) "Aprobó" else "Reprobó"

        tvResultado.text = "Estudiante: $nombre\nPromedio: %.2f\nEstado: $estado".format(promedio)
    }
}