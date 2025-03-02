package com.example.desafiopracticodsmjonathanr

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SalarioActivity : AppCompatActivity() {

    lateinit var etNombreEmpleado:EditText
    lateinit var etSalarioBase:EditText
    lateinit var btnCalcularSalario:Button
    lateinit var tvResultadoSalario:TextView
    lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_salario)

        etNombreEmpleado = findViewById(R.id.etNombreEmpleado)
        etSalarioBase = findViewById(R.id.etSalarioBase)
        btnCalcularSalario = findViewById(R.id.btnCalcularSalario)
        tvResultadoSalario = findViewById(R.id.tvResultadoSalario)
        btnRegresar = findViewById(R.id.btnRegresar)

        btnCalcularSalario.setOnClickListener {
            calcularSalario()
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun calcularSalario() {
        val nombre = etNombreEmpleado.text.toString()
        if (etSalarioBase.text.isNullOrEmpty()) {
            tvResultadoSalario.text = "Por favor, ingresa el salario base."
            return
        }

        val salarioBase = etSalarioBase.text.toString().toDouble()


        val afp = salarioBase * 0.0725
        val isss = salarioBase * 0.03


        val renta = if (salarioBase <= 0) {
            0.0
        } else if (salarioBase <= 472.0) {
            0.0
        } else if (salarioBase <= 895.24) {
            (salarioBase - 472) * 0.1 + 17.67
        } else if (salarioBase <= 2038.10) {
            (salarioBase - 895.24) * 0.2 + 60.00
        } else {
            (salarioBase - 2038.10) * 0.3 + 288.57
        }



        val salarioNeto = salarioBase - afp - isss - renta

        val resultado = """
            Empleado: $nombre
            Salario Base: $salarioBase
            AFP (7.25%%): %.2f
            ISSS (3%%): %.2f
            Renta: %.2f
            ------------------
            Salario Neto: %.2f
        """.trimIndent().format(afp, isss, renta, salarioNeto)

        tvResultadoSalario.text = resultado
    }
}