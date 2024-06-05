package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class DosisHora : AppCompatActivity() {

    lateinit var btnguardar: Button
    lateinit var timepicker1: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dosis_hora)

        //Botón icono que envía a la vista siguiente Instrucciones Medicamento----------------------
        val imageButton = findViewById<ImageButton>(R.id.btnhoradosisnext)
        imageButton.setOnClickListener {
            val intent = Intent(this,instrucciones::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista Administrar Dosis del Medicamento------------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btnhoradosisback)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------
        /*
        val timePicker = findViewById<TimePicker>(R.id.time_pickerdosis)

        timePicker.setOnTimeChangedListener{ view, hourOfDay, minute ->
            val seleccionarHora = hourOfDay
            val seleccionarMinuto = minute

            Toast.makeText(this, "Hora seleccionada: $seleccionarHora:$seleccionarMinuto", Toast.LENGTH_SHORT).show()
        }*/

        /* Button de guardar hora
        val btnGuardarDosisHora = findViewById<Button>(R.id.btnGuardarDosisHora)
        btnGuardarDosisHora.setOnClickListener {
            // Obtener la hora seleccionada del TimePicker
            val timePicker = findViewById<TimePicker>(R.id.time_pickerdosis)
            val hour = timePicker.hour
            val minute = timePicker.minute
            val selectedDosisHora = String.format(Locale.getDefault(), "%02d:%02d", hour, minute)

            // Guardar la hora en SharedPreferences
            val sharedPref = getSharedPreferences("MedicamentoPref", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("dosisHora", selectedDosisHora)
                apply()
            }

            Toast.makeText(this, "Dosis/Hora guardada", Toast.LENGTH_SHORT).show()
        }

        //------------------------------------------------------------------------------------------*/

        ////Button para guardar parámetros----------------------------------------------------------
        val btnGuardar = findViewById<Button>(R.id.btnGuardarDosisHora)
        val timePicker = findViewById<TimePicker>(R.id.time_pickerdosis)

        btnGuardar.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MedData", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("hora_dosis", "${timePicker.hour}:${timePicker.minute}")
            editor.apply()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}