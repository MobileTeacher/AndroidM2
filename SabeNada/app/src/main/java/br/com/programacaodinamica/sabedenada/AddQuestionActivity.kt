package br.com.programacaodinamica.sabedenada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_question.*

class AddQuestionActivity : AppCompatActivity() {

    val categories = listOf("Esportes",
                            "História",
                            "Matemática",
                            "Programação",
                            "Entretenimento")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)

        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item,
            categories)

        category_spinner.adapter = adapter

        category_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@AddQuestionActivity,
                    "Selecionou ${categories[p2]}",
                    Toast.LENGTH_LONG
                    ).show()
            }

        }

    }



}
