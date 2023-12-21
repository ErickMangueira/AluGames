package br.com.erick.aluGames.modelo

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}