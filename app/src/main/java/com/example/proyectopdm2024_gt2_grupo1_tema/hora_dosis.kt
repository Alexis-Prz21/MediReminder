package com.example.proyectopdm2024_gt2_grupo1_tema

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        time = findViewById(R.id.time)
        btnTime = findViewById(R.id.btnTime)

        btnTime.setOnClickListener{
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener{ view, hourOfDay, minute -> time.setText("$hourOfDay : $minute") },startHour,startMinute,false).show()
        }
    }
}