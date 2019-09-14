package br.com.programacaodinamica.sabedenada

class Question(val text: String,
               val options: List<String>,
               val answer: Int)


val question1 = Question("Quantos são os sólidos de Platão?",
    listOf("5", "10", "15", "20"),
    0)

val question2 = Question("Em que ano foi proclamada a República brasileira?",
    listOf("1822", "1888", "1860", "1889"),
    3)

val question3 = Question("Qual timer está no topo?",
    listOf("Santos", "Internacional", "Flamengo", "Santa Cruz"),
    2)