package br.com.erick.aluGames.principal

import br.com.erick.aluGames.servicos.ConsumoApi

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamer = consumoApi.buscaGamer()
    println(listaGamer)

}