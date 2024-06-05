package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MedicamentoPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_medicamento_page)

        val sharedPreferences = getSharedPreferences("MedData", MODE_PRIVATE)
        val tvAgregarMed = findViewById<TextView>(R.id.tvAgregarMed)
        val tvHoraDosis = findViewById<TextView>(R.id.tvHoraDosis)
        val tvFormato = findViewById<TextView>(R.id.tvFormato)
        val tvInstrucciones = findViewById<TextView>(R.id.tvInstrucciones)

        val extras = intent.extras
        if (extras != null) {
            tvAgregarMed.text = extras.getString("medicamento", "")
            tvHoraDosis.text = extras.getString("hora_dosis", "")
            tvFormato.text = extras.getString("formato", "")
            tvInstrucciones.text = extras.getString("instrucciones", "")
        }

        val btnClearData = findViewById<Button>(R.id.btnClearData)
        btnClearData.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("¿Estás seguro de que deseas eliminar los datos?")
                .setCancelable(false)
                .setPositiveButton("Sí") { _, _ ->
                    val editor = sharedPreferences.edit()
                    editor.clear()
                    editor.apply()
                    tvAgregarMed.text = ""
                    tvHoraDosis.text = ""
                    tvFormato.text = ""
                    tvInstrucciones.text = ""
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.cancel()
                }
            val alert = dialogBuilder.create()
            alert.show()
        }


        //Botón icono que envía a la vista siguiente HomePage---------------------------------------
        val imageButton = findViewById<ImageButton>(R.id.btnInicio)
        imageButton.setOnClickListener {
            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista siguiente HistorialPage----------------------------------
        val imageButton2 = findViewById<ImageButton>(R.id.btnHistorial)
        imageButton2.setOnClickListener {
            val intent = Intent(this,HistorialPage::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        //Botón icono que envía a la vista siguiente AgregarMedicamento----------------------------------
        val Button = findViewById<Button>(R.id.btnagregar)
        Button.setOnClickListener {
            val intent = Intent(this,AgregarMedicamento::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------

        /* Add button to clear data
        val btnClearData = findViewById<Button>(R.id.btnClearData)
        btnClearData.setOnClickListener {
            with(sharedPref.edit()) {
                clear()
                apply()
            }
            tvInstrucciones.text = "Instrucciones: No guardado"
            tvFormato.text = "Formato: No guardado"
            Toast.makeText(this, "Datos borrados", Toast.LENGTH_SHORT).show()
        }*/



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}