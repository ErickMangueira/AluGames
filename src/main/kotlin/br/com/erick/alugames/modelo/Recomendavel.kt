package br.com.erick.alugames.modelo

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}