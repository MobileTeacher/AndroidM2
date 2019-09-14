package br.com.programacaodinamica.sabedenada

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.programacaodinamica.sabedenada.model.Question
import br.com.programacaodinamica.sabedenada.model.question1
import br.com.programacaodinamica.sabedenada.model.question2
import br.com.programacaodinamica.sabedenada.model.question3

class QuestionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    // dados para a RecyclerView
    val items = mutableListOf<Question>(question1, question2, question3)

    override fun getItemCount() = items.size
//    override fun getItemCount(): Int {
//        return items.size
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.question_card, parent, false)
        //De posse do card que será replicado, podemos construir e retornar um QuestionViewHolder
        return QuestionViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is QuestionViewHolder){
            val question = items[position]
            holder.questionTextView.text = question.text
        }
    }

    class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //itemView é o card (View) que será replicado na lista
        val questionTextView: TextView = itemView.findViewById(R.id.question_textview)
    }
}