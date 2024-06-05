package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FrecuenciaMedicamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_frecuencia_medicamento)

        //Ruta de los botones a las siguientes vistas------------------------------------
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this,DosisAdministrarMedicamento::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this,SeleccionarDiasRecordatorios::class.java)
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this,IntervaloDias::class.java)
            startActivity(intent)
        }

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this,IntervaloSemanaActivity::class.java)
            startActivity(intent)
        }

        //--------------------------------------------------------------------------------

        //Botón icono que envía a la vista atrás Seleccionar el formato del medicamento-------------
        val imageButton = findViewById<ImageButton>(R.id.btnfrecuenciaatras)
        imageButton.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}