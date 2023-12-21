package br.com.erick.aluGames.principal

import br.com.erick.aluGames.modelo.Gamer
import br.com.erick.aluGames.modelo.Jogo
import br.com.erick.aluGames.servicos.ConsumoApi
import transformarEmIdade
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido com sucesso:")
    println(gamer)
    println("\n Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())
//    do {
//        println("Digite o código de jogo para buscar: ")
//        val busca = leitura.nextLine()
//
//        val buscaApi = ConsumoApi()
//
//        var meuJogo: Jogo? = null

//        val resultado = runCatching {
//            val informacaoJogo = buscaApi.buscaJogosJson(busca)
//            if (informacaoJogo != null) {
//                meuJogo = Jogo(
//                    informacaoJogo.info.title,
//                    informacaoJogo.info.thumb
//                )
//            }
//        }
//        resultado.onFailure {
//            println("Jogo inexistente. Tente outro jogo")
//        }
//        resultado.onSuccess {
//            println("Deseja inserir uma descrição personalizada? S/N")
//            val opcao = leitura.nextLine()
//            if (opcao.equals("s", true)) {
//                println("Insira a descrição personalizada para o jogo:")
//                val descricaoPersonalizada = leitura.nextLine()
//                meuJogo?.descricao = descricaoPersonalizada
//            } else {
//                meuJogo?.descricao = meuJogo?.titulo
//            }
//            gamer.jogosBuscados.add(meuJogo)
//        }
//        println("Deseja buscar um novo jogo? S/N")
//        val resposta = leitura.nextLine()
//    } while (resposta.equals("s", true))
//
//    println("Jogos buscados:")
//    println(gamer.jogosBuscados)
//
//    println("\n Jogos ordenados por titulo")
//    gamer.jogosBuscados.sortBy {
//        it?.titulo
//    }
//    gamer.jogosBuscados.forEach {
//        println("Titulo: " + it?.titulo)
//    }
//
//    val jogosFiltrados = gamer.jogosBuscados.filter {
//        it?.titulo?.contains("batman", true) ?: false
//    }
//    println("\n Jogos filtrados:")
//    println(jogosFiltrados)
//
//    println("Deseja excluir algum jogo da lista original? S/N")
//    val opcao = leitura.nextLine()
//    if (opcao.equals("s", true)) {
//        println(gamer.jogosBuscados)
//        println("\n informe a posição do jogo que deseja excluir: ")
//        val posicao = leitura.nextInt()
//        gamer.jogosBuscados.removeAt(posicao)
//    }
//    println("\n Lista atualizada")
//    println(gamer.jogosBuscados)
//
//
//    println("Busca finalizada com sucesso.")

}