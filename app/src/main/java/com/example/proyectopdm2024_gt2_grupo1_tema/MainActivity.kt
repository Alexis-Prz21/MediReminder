package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p12)

        val btn: TextView = findViewById(R.id.txtVRegistro)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, RegistroUsuario::class.java)
            startActivity(intent)
        }
    }
}