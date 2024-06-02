package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment


class SeleccionarDiasRecordatorios : AppCompatActivity(), MultipleChoiceDialogFragment.OnMultiChoiceListener{

    //Alert Dialog con CheckBox para la vista de Seleccionar Días de Recordatorio------------------------------------
    private lateinit var tvseleccionardias: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccionar_dias_recordatorios)

        tvseleccionardias = findViewById(R.id.tvseleccionardias);

        val btnSelectChoices: Button = findViewById(R.id.btnseleccionardias)
        btnSelectChoices.setOnClickListener {
            //val multiChoiceDialog = MultipleChoiceDialogFragment()
            val multiChoiceDialog =
                com.example.proyectopdm2024_gt2_grupo1_tema.MultipleChoiceDialogFragment()
            multiChoiceDialog.isCancelable = false
            multiChoiceDialog.show(supportFragmentManager, "Multichoice Dialog")
        }
    //----------------------------------------------------------------------------------------------------------------


        //Botón icono que envía a la vista atrás Seleccionar la frecuencia administrada---------
        val imageButton2 = findViewById<ImageButton>(R.id.btnrecordatorioatras)
        imageButton2.setOnClickListener {
            finish()
        }
        //------------------------------------------------------------------------------------------

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onPositiveButtonClicked(list: Array<String>, selectedItemList: ArrayList<String>) {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Selected Days = ")
        for (str in selectedItemList) {
            stringBuilder.append("$str ")
        }
        tvseleccionardias.text = stringBuilder.toString()
    }

    override fun onNegativeButtonClicked() {
        tvseleccionardias.text = "Dialog Cancel"
    }
}
