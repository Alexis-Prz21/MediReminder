package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class instrucciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_instrucciones)

        //AutoCompleteTextView de las instrucciones del medicamento------------------------------------------------------------------------------------
        val items = listOf("Antes de comer","Durante la comida","Después de comer","En la mañana","En la noche","Ninguno")

        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_Complete4)
        val adapter = ArrayAdapter(this,R.layout.list_item,items)
        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }
        //------------------------------------------------------------------------------------------

        ///Botón icono que envía a la vista siguiente Presentación de recordatorio------------------
        val button = findViewById<Button>(R.id.btnaceptarins)
        button.setOnClickListener {
            val intent = Intent(this,presentacionRecordatorio::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista atrás Hora Dosis-----------------------------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btninstruccionesback)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------

        /*Button de guardar instrucciones
        val btnGuardarInstrucciones = findViewById<Button>(R.id.btnGuardarInstrucciones)
        btnGuardarInstrucciones.setOnClickListener {
            val selectedInstruction = autoComplete.text.toString()
            if (selectedInstruction.isNotEmpty()) {
                val sharedPref = getSharedPreferences("MedicamentoPref", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("instrucciones", selectedInstruction)
                    apply()
                }
                Toast.makeText(this, "Instrucción guardada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Seleccione una instrucción", Toast.LENGTH_SHORT).show()
            }
        }*/

        val btnGuardar = findViewById<Button>(R.id.btnGuardarInstrucciones)
        val autoComplete4 = findViewById<AutoCompleteTextView>(R.id.auto_Complete4)

        btnGuardar.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MedData", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("instrucciones", autoComplete4.text.toString())
            editor.apply()
        }

    }
}