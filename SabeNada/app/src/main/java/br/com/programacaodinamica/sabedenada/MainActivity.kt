package br.com.programacaodinamica.sabedenada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val questions = listOf(question1, question2, question3)
    var currentIndex = 0
    var selectedOption = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpQuestion(currentIndex)
        setUpListeners()
    }

    // Configura uma pergunta na tela
    fun setUpQuestion(currentIndex: Int){
        val currentQuestion = questions[currentIndex]
        question_textview.text = currentQuestion.text
        option0_radiobutton.text = currentQuestion.options[0]
        option1_radiobutton.text = currentQuestion.options[1]
        option2_radiobutton.text = currentQuestion.options[2]
        option3_radiobutton.text = currentQuestion.options[3]
    }

    // Configura botões e outras views interativas
    fun setUpListeners(){
        // adiciona uma função ao botão
        confirmation_button.setOnClickListener {
            // verifica qual opção foi seleciona
            selectedOption = when(radiogroup.checkedRadioButtonId){
                R.id.option0_radiobutton -> 0
                R.id.option1_radiobutton -> 1
                R.id.option2_radiobutton -> 2
                R.id.option3_radiobutton -> 3
                else -> -1
            }

            if (selectedOption != -1){ //se não é uma opção inválida
                val currentQuestion = questions[currentIndex]
                if (selectedOption == currentQuestion.answer){
                    Toast.makeText(this,
                        "Parabéns, você acertou!",
                        Toast.LENGTH_LONG).show()

                    // apaga opção selecionada
                    radiogroup.clearCheck()
                    // avança para próxima pergunta
                    currentIndex = (currentIndex + 1)%questions.size
                    setUpQuestion(currentIndex)



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
