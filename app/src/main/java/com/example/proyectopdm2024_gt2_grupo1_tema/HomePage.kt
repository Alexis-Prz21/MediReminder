package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        //Botón icono que envía a la vista siguiente MedicamentoPage--------------------------------
        val imageButton = findViewById<ImageButton>(R.id.btnMedicamento)
        imageButton.setOnClickListener {
            val intent = Intent(this,MedicamentoPage::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista siguiente HistorialPage--------------------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btnHistorial)
        imageButton2.setOnClickListener {
            val intent = Intent(this,HistorialPage::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}