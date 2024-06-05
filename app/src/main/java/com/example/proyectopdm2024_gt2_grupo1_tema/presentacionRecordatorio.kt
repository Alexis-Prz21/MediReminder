package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class presentacionRecordatorio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_presentacion_recordatorio)

        //Botón icono que envía a la vista atrás Instrucciones del medicamento----------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btnP_recordback)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------

        //TextView que envía a la vista siguiente Alarma visual-------------------------------------
        val txtalarmavisual = findViewById<TextView>(R.id.txtAlarmaVisual)
        txtalarmavisual.setOnClickListener {
            val intent = Intent(this,alarmaVisual::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        //PENDIENTE BOTON GUARDAR DE ALARMA SONORA Y ALARMA VIBRANTE

    }
}