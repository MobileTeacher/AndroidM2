package br.com.programacaodinamica.sabedenada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_menu.*
import java.io.File

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setUpListeners()
    }

    fun setUpListeners(){

        val playButton = findViewById<Button>(R.id.play_button)

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

        clear_button.setOnClickListener {
            val file = File(filesDir, QUESTION_FILE)
            file.delete()
        }
    }
}
