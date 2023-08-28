package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var edtNumero1: EditText
    lateinit var edtNumero2: EditText
    lateinit var btnSumar: Button
    lateinit var txtResultado: TextView
    lateinit var btnRaiz: Button
    lateinit var btnPotencia: Button
    lateinit var btnUnosobre: Button
    lateinit var btnDivision: Button
    lateinit var btnLimpiar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtNumero1 = findViewById(R.id.edtNumero1)
        edtNumero2 = findViewById(R.id.edtNumero2)
        btnSumar = findViewById(R.id.btnSumar)
        txtResultado = findViewById(R.id.txtResultado)
        btnPotencia = findViewById(R.id.btnPotencia)
        btnRaiz = findViewById(R.id.btnRaiz)
        btnUnosobre = findViewById(R.id.btnUnosobre)
        btnDivision = findViewById(R.id.btnDivision)
        btnLimpiar = findViewById(R.id.btnLimpiar)

        btnSumar.setOnClickListener (View.OnClickListener {
            val num1 = Integer.parseInt(edtNumero1.text.toString())
            val num2 = Integer.parseInt(edtNumero2.text.toString())

            txtResultado.setText("Resultado: "+ sumar(num1, num2))
        })
        btnPotencia.setOnClickListener {
            val baseText = edtNumero1.text.toString()
            val exponentText = edtNumero2.text.toString()

            if (baseText.isNotEmpty() && exponentText.isNotEmpty()) {
                val base = baseText.toDouble()
                val exponent = exponentText.toDouble()
                val result = base.pow(exponent)
                txtResultado.text = "Resultado: $result"
            } else {
                txtResultado.text = "Ingrese ambos números"
            }
        }
        btnRaiz.setOnClickListener {
            calcularraizcuadrada()
        }
        btnUnosobre.setOnClickListener {
            calculrunosobre()
        }
       btnDivision.setOnClickListener {
            calcularDivision()
        }
        btnLimpiar.setOnClickListener {
            limpiarcampos()
        }
    }
    private fun calcularraizcuadrada() {
        val number1Text = edtNumero1.text.toString()
        val number2Text = edtNumero2.text.toString()

        try {
            val number1 = number1Text.toDouble()
            val number2 = number2Text.toDouble()

            val squareRoot1 = Math.sqrt(number1)
            val squareRoot2 = Math.sqrt(number2)

            txtResultado.text = "Raíz cuadrada de Número 1: $squareRoot1\nRaíz cuadrada de Número 2: $squareRoot2"
        } catch (e: NumberFormatException) {
            txtResultado.text = "Ingrese números válidos"
        }
    }

    fun sumar(numero1: Int, numero2: Int) : Int{
        return numero1 + numero2
    }
    private fun calculrunosobre() {
        val number1Text = edtNumero1.text.toString()
        val number2Text = edtNumero2.text.toString()

        try {
            val number1 = number1Text.toDouble()
            val number2 = number2Text.toDouble()

            val reciprocal1 = 1.0 / number1
            val reciprocal2 = 1.0 / number2

            txtResultado.text = "Número 1: $reciprocal1\nNúmero 2: $reciprocal2"
        } catch (e: NumberFormatException) {
            txtResultado.text = "Ingrese números válidos en ambos campos"
        } catch (e: ArithmeticException) {
           txtResultado.text = "No se puede calcular la recíproca de 0"
        }
    }
    private fun calcularDivision() {
        val number1Text = edtNumero1.text.toString()
        val number2Text = edtNumero2.text.toString()

        try {
            val number1 = number1Text.toDouble()
            val number2 = number2Text.toDouble()

            if (number2 != 0.0) {
                val divisionResult = number1 / number2
                txtResultado.text = "Resultado: $divisionResult"
            } else {
                txtResultado.text = "No se puede dividir por 0"
            }
        } catch (e: NumberFormatException) {
            txtResultado.text = "Ingrese números válidos"
        }
    }
    private fun limpiarcampos() {
        edtNumero1.text.clear()
        edtNumero2.text.clear()
        txtResultado.text = ""
    }

}