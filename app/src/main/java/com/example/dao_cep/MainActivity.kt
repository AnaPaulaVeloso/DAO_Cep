package com.example.dao_cep

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtCep = findViewById<EditText>(R.id.edtCep)
        val btnConsultarCep = findViewById<Button>(R.id.btnConsultarCep)

        btnConsultarCep.setOnClickListener {
            val cep = edtCep.text.toString()

            val intent = Intent(this, Resultado_Activity::class.java).apply {
                putExtra("CEP", cep)
            }
            startActivity(intent)
        }
    }

    }
}