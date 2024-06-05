package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class sintomaSecundario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sintoma_secundario)


        val btnGuardarMedAlarma = findViewById<Button>(R.id.btnGuardarMedAlarma)

        btnGuardarMedAlarma.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MedData", MODE_PRIVATE)
            val medicamento = sharedPreferences.getString("medicamento", "")
            val horaDosis = sharedPreferences.getString("hora_dosis", "")
            val formato = sharedPreferences.getString("formato", "")
            val instrucciones = sharedPreferences.getString("instrucciones", "")

            val intent = Intent(this, MedicamentoPage::class.java)
            intent.putExtra("medicamento", medicamento)
            intent.putExtra("hora_dosis", horaDosis)
            intent.putExtra("formato", formato)
            intent.putExtra("instrucciones", instrucciones)
            startActivity(intent)
        }



        //Botón icono que envía a la vista atrás Alarma Visual--------------------------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btnsintomaback)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------

    }
}