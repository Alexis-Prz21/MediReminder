package com.example.proyectopdm2024_gt2_grupo1_tema

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.Period
import java.util.Calendar

class hora_dosis : AppCompatActivity() {

    private lateinit var  time: TextView
    private lateinit var btnTime: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hora_dosis)

        val timePicker = findViewById<TimePicker>(R.id.time_picker)

        timePicker.setOnTimeChangedListener{ view, hourOfDay, minute ->
            val seleccionarHora = hourOfDay
            val seleccionarMinuto = minute

            Toast.makeText(this, "Hora seleccionada: $seleccionarHora:$seleccionarMinuto", Toast.LENGTH_SHORT).show()
        }
    }
}