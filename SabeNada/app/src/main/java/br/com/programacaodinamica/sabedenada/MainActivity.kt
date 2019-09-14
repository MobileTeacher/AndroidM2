package br.com.programacaodinamica.sabedenada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val questions = listOf(question1, question2)
    var currentIndex = 0
    var selectedOption = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Configura uma pergunta na tela
        val currentQuestion = questions[currentIndex]
        question_textview.text = currentQuestion.text
        option0_radiobutton.text = currentQuestion.options[0]
        option1_radiobutton.text = currentQuestion.options[1]
        option2_radiobutton.text = currentQuestion.options[2]
        option3_radiobutton.text = currentQuestion.options[3]


        // adiciona uma função ao botão
        confirmation_button.setOnClickListener {

            selectedOption = when(radiogroup.checkedRadioButtonId){
                R.id.option0_radiobutton -> 0
                R.id.option1_radiobutton -> 1
                R.id.option2_radiobutton -> 2
                R.id.option3_radiobutton -> 3
                else -> -1
            }

            if (selectedOption != -1){
                if (selectedOption == currentQuestion.answer){
                    Toast.makeText(this,
                        "Parabéns, você acertou!",
                        Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this,
                        "ERROU!!!!",
                        Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this,
                    "Selecione uma alternativa!",
                    Toast.LENGTH_LONG).show()
            }

        }

    }



}
