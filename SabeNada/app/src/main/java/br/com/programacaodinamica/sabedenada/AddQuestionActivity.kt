package br.com.programacaodinamica.sabedenada

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.com.programacaodinamica.sabedenada.model.Question
import kotlinx.android.synthetic.main.activity_add_question.*
import java.io.File
import java.io.FileOutputStream


const val QUESTION_FILE = "all_questions.txt"

class AddQuestionActivity : AppCompatActivity() {

    val categories = listOf("Esportes",
                            "História",
                            "Matemática",
                            "Programação",
                            "Entretenimento")

    var category = categories[0]
    var text = ""
    // lista mutável
    var options = mutableListOf("", "", "", "")
    var answer = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)

        setUpSpinner()
        setUpListeners()

    }

    fun setUpListeners(){
        // configurar a ação do botão
        save_button.setOnClickListener {
            text = question_input.text.toString()
            options[0] = option0_edittext.text.toString()
            options[1] = option1_edittext.text.toString()
            options[2] = option2_edittext.text.toString()
            options[3] = option3_edittext.text.toString()
            answer = when(choices_radiogroup.checkedRadioButtonId){
                R.id.choice0_radiobutton -> 0
                R.id.choice1_radiobutton -> 1
                R.id.choice2_radiobutton -> 2
                R.id.choice3_radiobutton -> 3
                else -> -1
            }
            clearForm()
            // próximo passo, encerrar formulário e construir pergunta
            val question = Question(text, options, answer, category)
            random_question_textview.text = "$question" //question.toString()
            //salva pergunta no arquivo
            saveQuestion(question)

        }
    }

    fun clearForm(){
        question_input.setText("")
        option0_edittext.setText("")
        option1_edittext.setText("")
        option2_edittext.setText("")
        option3_edittext.setText("")
        choices_radiogroup.clearCheck()
    }


    fun setUpSpinner(){
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item,
            categories)

        category_spinner.adapter = adapter

        category_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, index: Int, p3: Long) {
                // guarda o valor da categoria selecionada no Spinner
                category = categories[index]
            }

        }
    }

    fun saveQuestion(question: Question){
        val file = File(filesDir, QUESTION_FILE)
        FileOutputStream(file, true).use {
            it.write("#\n$question\n".toByteArray())
        }

    }

}
