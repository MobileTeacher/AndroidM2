package br.com.programacaodinamica.sabedenada

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.programacaodinamica.sabedenada.model.Question
import kotlinx.android.synthetic.main.activity_question_list.*
import java.lang.Exception

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
        ReadTask().execute()
    }

    fun readQuestions(): MutableList<Question>{
        val questions = mutableListOf<Question>()
        try {
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
        } catch (exception: Exception){

        }
        return  questions
    }

    inner class ReadTask : AsyncTask<Unit, Unit, MutableList<Question>>(){

        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: Unit?): MutableList<Question> {
            Thread.sleep(3000)
           return readQuestions()
        }

        override fun onPostExecute(result: MutableList<Question>?) {
            super.onPostExecute(result)
            if (result != null){
                val adapter = question_list.adapter
                if (adapter is QuestionAdapter){
                    adapter.setData(result)
                }
            }
            progressBar.visibility = View.GONE
        }

    }

}
