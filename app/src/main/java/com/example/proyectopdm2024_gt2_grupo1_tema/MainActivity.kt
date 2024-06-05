package com.example.proyectopdm2024_gt2_grupo1_tema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.proyectopdm2024_gt2_grupo1_tema.dbresource.DatabaseHelper

class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginButton: Button
    lateinit var registerTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // dbHelper = DatabaseHelper(this)
        //val db = dbHelper.writableDatabase


        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.btnLogin)
        registerTV = findViewById(R.id.txtRegister)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val storedEmail = sharedPreferences.getString("email", "")
            val storedPassword = sharedPreferences.getString("password", "")

            if (email == storedEmail && password == storedPassword) {
                // Login correcto, pasa a HomePage
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            } else {
                // Error login
                Toast.makeText(this, "Correo o contraseña inválidos", Toast.LENGTH_SHORT).show()
            }
        }

        registerTV.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }




    }
}