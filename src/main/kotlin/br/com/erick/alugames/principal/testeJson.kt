package br.com.erick.alugames.principal

import br.com.erick.alugames.modelo.Periodo
import br.com.erick.alugames.modelo.PlanoAssinatura
import br.com.erick.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamer = consumoApi.buscaGamer()
    val listajogo = consumoApi.buscaJogosJson()

    val gamer1 = listaGamer.get(3)
    val jogo1 = listajogo.get(10)
    val jogo2 = listajogo.get(13)
    val jogo3 = listajogo.get(2);
    println(gamer1)
    println(jogo1)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo3 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))

    gamer1?.alugaJogo(jogo1, periodo)
    gamer1?.alugaJogo(jogo2, periodo1)
    gamer1?.alugaJogo(jogo3, periodo2)
    gamer1?.alugaJogo(jogo3, periodo2)
    println(gamer1?.jogosAlugados)
    gamer1?.alugaJogo(jogo3,periodo3)

    println(gamer1?.jogosDoMes(8))

    val gamer2 = listaGamer.get(5)
    gamer2?.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    gamer2?.alugaJogo(jogo2, periodo1)
    gamer2?.alugaJogo(jogo3, periodo2)
    gamer2?.alugaJogo(jogo1, periodo1)
    gamer2?.alugaJogo(jogo1, periodo1)
    println(gamer2?.jogosAlugados)

    gamer2?.recomendar(7)
    gamer2?.recomendar(10)
    gamer2?.recomendar(8)
    println(gamer2)

    gamer2?.alugaJogo(jogo1, periodo1)
    println(gamer2?.jogosAlugados)

    gamer2?.recomendarJogo(jogo1, 7)
    gamer2?.recomendarJogo(jogo2, 10)

    gamer1?.recomendarJogo(jogo1, 5)
    gamer1?.recomendarJogo(jogo2, 9)

    println(gamer2?.jogosRecomendados)
    println(gamer1?.jogosRecomendados)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamer2?.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamer2?.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)


}