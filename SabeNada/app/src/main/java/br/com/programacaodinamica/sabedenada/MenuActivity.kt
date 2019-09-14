package br.com.programacaodinamica.sabedenada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setUpListeners()
    }

    fun setUpListeners(){


        play_button.setOnClickListener {
            // Ir para tela de "Jogo do Quiz"
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        list_button.setOnClickListener {
            // Ir para tela de "Lista de Perguntas"
            val intent = Intent(this, QuestionListActivity::class.java)
            startActivity(intent)
        }

        add_button.setOnClickListener {
            // Ir para tela de "Adicionar Pergunta"
            startActivity(Intent(this, AddQuestionActivity::class.java))
        }

    }
}
