package com.example.dao_cep

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dao_cep.dao.Endereco
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

class Resultado_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        intent.getStringExtra("CEP")?.let { cep ->
            thread {
                val response = URL("https://viacep.com.br/ws/$cep/json/").readText()
                val json = JSONObject(response)
                val endereco = Endereco(
                    json.getString("cep"),
                    json.getString("logradouro"),
                    json.getString("complemento"),
                    json.getString("bairro"),
                    json.getString("localidade"),
                    json.getString("uf")
                )
                runOnUiThread {
                    txtResultado.text = endereco.toString()
                    println(endereco.toString())
                }
            }
        }
    }
}