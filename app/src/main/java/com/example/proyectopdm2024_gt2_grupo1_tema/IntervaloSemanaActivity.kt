package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
import android.widget.Toast

class IntervaloSemanaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intervalo_semana)

        //AutoCompleteTextView del intervalo de Semanas del medicamento---------------------------------------------
        val items = listOf("1", "2","3","4","5","6","7","8","9","10")

        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_Complete5)
        val adapter = ArrayAdapter(this,R.layout.list_item,items)
        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista atrás Seleccionar la frecuencia administrada-------------
        val imageButton2 = findViewById<ImageButton>(R.id.btnsemanaatras)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista siguiente Dosis Administrar Medicamento---------
        val imageButton = findViewById<ImageButton>(R.id.btnsemananext)
        imageButton.setOnClickListener {
            val intent = Intent(this,DosisAdministrarMedicamento::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------
    }
}