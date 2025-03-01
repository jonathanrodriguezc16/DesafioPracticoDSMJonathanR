package com.example.desafiopracticodsmjonathanr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btnPromedio: Button
    lateinit var btnSalario: Button
    lateinit var btnCalculadora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnPromedio=findViewById(R.id.btnPromedio)
        btnSalario = findViewById(R.id.btnSalario)
        btnCalculadora=findViewById(R.id.btnCalculadora)

        btnPromedio.setOnClickListener {
            val intent =Intent(this, PromedioActivity::class.java)
            startActivity(intent)
        }
        btnSalario.setOnClickListener {
            val intent =Intent(this, SalarioActivity::class.java)
            startActivity(intent)
        }
        btnCalculadora.setOnClickListener {
            val intent =Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }

    }
}