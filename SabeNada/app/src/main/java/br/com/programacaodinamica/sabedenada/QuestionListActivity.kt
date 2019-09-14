package br.com.programacaodinamica.sabedenada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.programacaodinamica.sabedenada.model.Question
import kotlinx.android.synthetic.main.activity_question_list.*

class QuestionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)

        // Configura a RecyclerView
        question_list.adapter = QuestionAdapter()
        // Lista vertical de cima para baixo
        question_list.layoutManager = LinearLayoutManager(this)
        //GridLayoutManager(this, 2)//StaggeredGridLayoutManager(2,
        //                                    StaggeredGridLayoutManager.VERTICAL)

    }

    override fun onStart() {
        super.onStart()
        val adapter = question_list.adapter
        if (adapter is QuestionAdapter){
            adapter.setData(readQuestions())
        }
    }

    fun readQuestions(): MutableList<Question>{
        val questions = mutableListOf<Question>()
        openFileInput(QUESTION_FILE).use {
            it.bufferedReader().use { reader->
                var line = reader.readLine()
                while (line == "#"){
                    val text = reader.readLine()
                    val options =  mutableListOf<String>()
                    for (i in 0 until 4){
                        options.add(reader.readLine())
                    }
                    val answer = reader.readLine().toInt()
                    val category = reader.readLine()
                    val question = Question(text, options, answer, category)
                    questions.add(question)

                    line = reader.readLine()
                }
            }
        }
        return  questions
    }

}
