package br.com.programacaodinamica.sabedenada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val questions = listOf(question1, question2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adiciona uma função ao botão
        confirmation_button.setOnClickListener {
            Toast.makeText(this,
                "Foi Clicado!",
                Toast.LENGTH_LONG).show()
        }

    }
}
