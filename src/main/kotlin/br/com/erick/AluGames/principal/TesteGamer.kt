package br.com.erick.AluGames.principal

import br.com.erick.AluGames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Erick", "erick@email.com")
    println(gamer1)
    val gamer2 = Gamer("Dayane", "dayane@email.com", "02/12/1994", "day0212")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "erick"
        it.idInterno = "erick1234"
    }
    println(gamer1)
}