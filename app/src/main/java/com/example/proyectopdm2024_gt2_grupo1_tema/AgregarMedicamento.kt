package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AgregarMedicamento : AppCompatActivity() {

    lateinit var btnguardar: Button
    lateinit var edEditMedi: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_medicamento)

        //Botón icono que envía a la vista siguiente Seleccionar el formato del medicamento---------
        val imageButton = findViewById<ImageButton>(R.id.buttoningresarnext)
        imageButton.setOnClickListener {
            val intent = Intent(this,FormatoMedicina::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista atrás de donde vino--------------------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btningresarback)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------

        //Button para guardar parámetros------------------------------------------------------------
        val btnGuardar = findViewById<Button>(R.id.btnguardar)
        val txtEditMedi = findViewById<EditText>(R.id.txtEditMedi)

        btnGuardar.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MedData", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("medicamento", txtEditMedi.text.toString())
            editor.apply()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}