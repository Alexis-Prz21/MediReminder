package com.example.proyectopdm2024_gt2_grupo1_tema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast

class HoraPrimeraDosisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hora_primera_dosis)

        val timePicker = findViewById<TimePicker>(R.id.date_picker)

        timePicker.setOnTimeChangedListener{ view, hourOfDay, minute ->
            val seleccionarHora = hourOfDay
            val seleccionarMinuto = minute

            Toast.makeText(this, "Hora seleccionada: $seleccionarHora:$seleccionarMinuto", Toast.LENGTH_SHORT).show()
        }
    }
}