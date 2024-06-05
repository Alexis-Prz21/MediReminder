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

class FormatoMedicina : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formato_medicina)

        //AutoCompleteTextView de los formatos del medicamento------------------------------------------------------------------------------------
        val items = listOf("Pastilla", "Cápsula", "Inyección", "Cápsula de gel", "Líquido", "Polvos", "Gotas", "Inhalador", "Pomada", "Otro")

        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_Complete)
        val adapter = ArrayAdapter(this,R.layout.list_item,items)
        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista atrás Agregar Medicamento--------------------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btnformatoatras)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista siguiente Seleccionar la frecuencia administrada---------
        val imageButton = findViewById<ImageButton>(R.id.btnformatonext)
        imageButton.setOnClickListener {
            val intent = Intent(this,FrecuenciaMedicamento::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        /* Button de guardar formato
        val btnGuardarFormato = findViewById<Button>(R.id.btnGuardarFormato)
        btnGuardarFormato.setOnClickListener {
            val selectedFormat = autoComplete.text.toString()
            if (selectedFormat.isNotEmpty()) {
                val sharedPref = getSharedPreferences("MedicamentoPref", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("formato", selectedFormat)
                    apply()
                }
                Toast.makeText(this, "Formato guardado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Seleccione un formato", Toast.LENGTH_SHORT).show()
            }
        }*/

        val btnGuardar = findViewById<Button>(R.id.btnGuardarFormato)
        val autoComplete1= findViewById<AutoCompleteTextView>(R.id.auto_Complete)

        btnGuardar.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MedData", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("formato", autoComplete1.text.toString())
            editor.apply()
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}