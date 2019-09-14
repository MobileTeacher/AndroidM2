package br.com.programacaodinamica.sabedenada.model

class Question(val text: String,
               val options: List<String>,
               val answer: Int,
               val category: String){

    override fun toString(): String {
        // Representando apenas texto da pergunta e resposta certa
        return "$text\n${options[answer]}"
        // Representando todos os atributos cada um em uma linha
//        return "$text\n${options.joinToString("\n")}\n$answer\n$category"
    }
}


val question1 = Question(
    "Quantos são os sólidos de Platão?",
    listOf("5", "10", "15", "20"),
    0, "Matemática"
)

val question2 = Question(
    "Em que ano foi proclamada a República brasileira?",
    listOf("1822", "1888", "1860", "1889"),
    3, "História"
)

val question3 = Question(
    "Qual timer está no topo?",
    listOf("Santos", "Internacional", "Flamengo", "Santa Cruz"),
    2, "Esportes"
)