package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
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





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}