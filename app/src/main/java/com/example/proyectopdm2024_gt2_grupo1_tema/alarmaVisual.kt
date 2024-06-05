package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class alarmaVisual : AppCompatActivity() {

    lateinit var tvNameMed: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alarma_visual)

        //Botón icono que envía a la vista siguiente Seleccionar sintoma secundario-----------------
        val imageButton = findViewById<ImageButton>(R.id.btnalarmanext)
        imageButton.setOnClickListener {
            val intent = Intent(this,sintomaSecundario::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista atrás Presentación recordatorio--------------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btnalarmaback)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------

        /*Recibe el medicamento agregado y lo muestra en el TextView--------------------------------
        tvNameMed = findViewById(R.id.tvnameMed)
        val sharedPreferences = getSharedPreferences("MedData", MODE_PRIVATE)
        val info = sharedPreferences.getString("keyDatos", "")
        tvNameMed.text = info*/

    }
}