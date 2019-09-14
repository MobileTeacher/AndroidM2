package br.com.programacaodinamica.sabedenada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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

    
}
