package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.proyectopdm2024_gt2_grupo1_tema.dbresource.DatabaseHelper

class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p12)

       // dbHelper = DatabaseHelper(this)
        //val db = dbHelper.writableDatabase

        val btn: TextView = findViewById(R.id.txtVRegistro)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, RegistroUsuario::class.java)
            startActivity(intent)
        }
    }
}